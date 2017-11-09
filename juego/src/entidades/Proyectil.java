package entidades;

import Hilos.HiloVueloProyectiles;
import Logica.Posicion;
import entidades.EntidadesGraficas.EntidadGraficaAtaque;

public abstract class Proyectil {

	//que tan rápido se mueve el proyectil
	protected int velocidadMovimiento;
	protected HiloVueloProyectiles miThread;
	protected boolean bloqueado;
	protected EntidadGraficaAtaque miGrafico;
	protected Posicion posActual;
	protected Posicion posFinal;
	
	//el proyectil puede ir en cualquier dirección, eso daria a 8 sprrites distintos que varian en una rotación del sprite inicial (Idle)
	
	public Proyectil (Posicion posActual, Posicion posFinal) {
		this.posActual = posActual;
		this.posFinal = posFinal;
		bloqueado = false;
	}
	
	public void desbloqueate () {
		bloqueado = false;
	}
	
	/**
	 * Metodo que se encarga de mover el proyectil de a un paso
	 * NOTA: Esto se hace en un contexto lógico
	 */
	public void volar () {
		if(!bloqueado) {
			System.out.println("estoy volando logicamente");
			int x1 = posActual.getX();
			int y1 = posActual.getY();
			int x2 = posFinal.getX();
			int y2 = posFinal.getY();
			
			if(miGrafico == null)
				System.out.println("Grafico nulo");
			if(posActual == null)
				System.out.println("Posicion Nula");
			if(velocidadMovimiento == 0)
				System.out.println("Velocidad Nula");
			
			int or = calcularOrientacion(x1,y1,x2,y2);
			
			switch(or){
				case 0:
					this.posActual.setX(this.posActual.getX() + velocidadMovimiento);
					miGrafico.moverA(posActual, velocidadMovimiento,0);
					break;
				case 1:
					posActual.setX(posActual.getX() + velocidadMovimiento);
					posActual.setY(posActual.getY() + velocidadMovimiento);
					bloqueado = true;
					miGrafico.desbloqueate();
					miGrafico.moverA(posActual, velocidadMovimiento,1);
					break;
				case 2:
					posActual.setY(posActual.getY() + velocidadMovimiento);
					bloqueado = true;
					miGrafico.desbloqueate();
					miGrafico.moverA(posActual, velocidadMovimiento,2);
					break;
				case 3:
					posActual.setX(posActual.getX() - velocidadMovimiento);
					posActual.setY(posActual.getY() + velocidadMovimiento);
					bloqueado = true;
					miGrafico.desbloqueate();
					miGrafico.moverA(posActual, velocidadMovimiento,3);
					break;
				case 4:
					posActual.setX(posActual.getX() - velocidadMovimiento);
					bloqueado = true;
					miGrafico.desbloqueate();
					miGrafico.moverA(posActual, velocidadMovimiento,4);
					break;
				case 5:
					posActual.setX(posActual.getX() - velocidadMovimiento);
					posActual.setY(posActual.getY() - velocidadMovimiento);
					bloqueado = true;
					miGrafico.desbloqueate();
					miGrafico.moverA(posActual, velocidadMovimiento,5);
					break;
				case 6:
					posActual.setY(posActual.getY() - velocidadMovimiento);
					bloqueado = true;
					miGrafico.desbloqueate();
					miGrafico.moverA(posActual, velocidadMovimiento,6);
					break;
				case 7:
					posActual.setX(posActual.getX() + velocidadMovimiento);
					posActual.setY(posActual.getY() - velocidadMovimiento);
					bloqueado = true;
					miGrafico.desbloqueate();
					miGrafico.moverA(posActual, velocidadMovimiento,7);
					break;
					
			}
		}
	}
	
	public void setPosicion(Posicion p) {
		posActual = p;
	}
	/**
	 * metodo usado para setear la gráfica cuando sea necesario
	 * @param p posicion inicial de la gráfica
	 */
	public abstract void setGrafico(Posicion p);
	
	public void Morir() {
		miThread = null;
		posActual = null;
		posFinal = null;
		miGrafico.Morir(); //si sali del while es porque llegué a mi objetivo, le debo decir a mi entidad grafica que se suicide
		miGrafico = null;
	
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
		private int calcularOrientacion(int x1, int y1, int x2, int y2) {
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

		public boolean llegoAlFinal() {
			return posActual.getX() == posFinal.getX() && posActual.getY() == posFinal.getY();
		}

}