package entidades.EntidadesGraficas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Logica.Posicion;

public class EntidadGraficaAtaque extends EntidadGrafica {
	
	protected ImageIcon [] OrientacionSprite = new ImageIcon [8];
	
	public EntidadGraficaAtaque (String [] File, Posicion pos) {
		super (File [0], pos);
		for (int I = 0; I < 8; I++) {
			OrientacionSprite [I] = new ImageIcon (File [I]);
		}
	}

	public void moverA(Posicion pos, int vel) {
		int orientacion = calcularOrientacion(this.pos.getX(), this.pos.getY(), pos.getX(), pos.getY());
		grafico = new JLabel (OrientacionSprite [orientacion]);
		while (this.pos.getX() != pos.getX() && this.pos.getY() != pos.getY()){
			try {
				//como como me muevo depende de la orientacion del proyectil y hay 8 direcciones posibles, es mejor un switch que 8 ifs seguidos
				//mirar este switch en conjunto con el método "calcularOrientacion" para mejor entendimiento
				switch(orientacion){
					case 0:
						this.grafico.setBounds(this.pos.getX() + vel, this.pos.getY(), 20, 20);
						this.pos.setX(this.pos.getX() + vel);
						Thread.sleep(100);
						break;
					case 1:
						this.grafico.setBounds(this.pos.getX() + vel, this.pos.getY() + vel,20,20);
						this.pos.setX(this.pos.getX() + vel);
						this.pos.setY(this.pos.getY() + vel);
						Thread.sleep(100);
						break;
					case 2:
						this.grafico.setBounds(this.pos.getX(), this.pos.getY() + vel, 20,20);
						this.pos.setY(this.pos.getY() + vel);
						Thread.sleep(100);
						break;
					case 3:
						this.grafico.setBounds(this.pos.getX() - vel, this.pos.getY() + vel, 20,20);
						this.pos.setX(this.pos.getX() - vel);
						this.pos.setY(this.pos.getY() + vel);
						Thread.sleep(100);
						break;
					case 4:
						this.grafico.setBounds(this.pos.getX() - vel, this.pos.getY(),20,20);
						this.pos.setX(this.pos.getX() - vel);
						Thread.sleep(100);
						break;
					case 5:
						this.grafico.setBounds(this.pos.getX()-vel, this.pos.getY()-vel,20,20);
						this.pos.setX(this.pos.getX() - vel);
						this.pos.setY(this.pos.getY() - vel);
						Thread.sleep(100);
						break;
					case 6:
						this.grafico.setBounds(this.pos.getX(),this.pos.getY() - vel,20,20);
						this.pos.setY(this.pos.getY() - vel);
						Thread.sleep(100);
						break;
					case 7:
						this.grafico.setBounds(this.pos.getX() + vel, this.pos.getY() + vel,20,20);
						this.pos.setX(this.pos.getY() + vel);
						this.pos.setY(this.pos.getY() - vel);
						Thread.sleep(100);
						break;
				}
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	
	
	//NOTA: asumo que la posicion donde el proyectil apunta hacia derecha es la posicion 1 del sprite y de ahi las demas se calculan siguiendo las agujas del reloj
	/**
	 * metodo que calcula como debe apuntar el sprite
	 * @param x1 coordenada x inicial
	 * @param y1 coordenada y inicial
	 * @param x2 coordenada x destino
	 * @param y2 coordenada y destino
	 * @return numero entre 0 a 7 que será usado en el arreglo de sprites
	 */
	public int calcularOrientacion(int x1, int y1, int x2, int y2) {
		int ret = 1; //default
		if(x1 == x2 && y1 != y2){
			if(y1 < y2){ //estoy sobre el eje Y positivo (Recordar que acá las coordenadas suben para abajo)
				ret = 3;
			}
			else{
				ret = 7; //estoy sobre el eje Y negativo
			}	
		}
		else{
			if(x1 != x2 && y1 == y2){
				if(x1 < x2){ //estoy en el eje X positivo
					ret = 1;
				}
				else
					ret = 5;
			}
			else{ //las cooredenadas pueden ser totalmente distintas o totalmente iguales
				if(x1 != x2 && y1 != y2){
					if(x1 < x2 && y1 < y2){ //estoy en la diagonal del cuarto cuadrante
						ret = 2;
					}
					else{
						if(x1 > x2 && y1 < y2){ //estoy en la diagonal del tercer cuadrante
							ret = 4;
						}
						else{
							if(x1 > x2 && y1 > y2){ //estoy en la diagonal del 2do cuadrante
								ret = 6;
							}
							else
								ret = 8; //si despues de todo terminé acá, es porque estoy en la diagonal del primer cuadrante
						}
					}
						
				}
				
			}
		}
		return ret - 1; //le resto 1 para no caerme del arreglo cuando el sprite levante este numero
	}

	
}
