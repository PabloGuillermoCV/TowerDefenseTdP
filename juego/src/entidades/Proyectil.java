package entidades;

import GUI.VueloProyectiles;
import Logica.Posicion;
import entidades.EntidadesGraficas.EntidadGraficaAtaque;

public abstract class Proyectil {

	//que tan r�pido se mueve el proyectil
	protected int velocidadMovimiento;
	protected VueloProyectiles miThread;
	protected EntidadGraficaAtaque miGrafico;
	protected Posicion posActual;
	protected Posicion posFinal;
	//el proyectil puede ir en cualquier direcci�n, eso daria a 8 sprrites distintos que varian en una rotaci�n del sprite inicial (Idle)
	
	public Proyectil (Posicion posActual, Posicion posFinal) {
		this.posActual = posActual;
		this.posFinal = posFinal;
	}
	
	/**
	 * Metodo que se encarga de mover el proyectil de a un paso
	 * NOTA: Esto se hace en un contexto l�gico
	 */
	public void volar(){
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
					miGrafico.moverA(posActual, velocidadMovimiento,1);
					break;
				case 2:
					posActual.setY(posActual.getY() + velocidadMovimiento);
					miGrafico.moverA(posActual, velocidadMovimiento,2);
					break;
				case 3:
					posActual.setX(posActual.getX() - velocidadMovimiento);
					posActual.setY(posActual.getY() + velocidadMovimiento);
					miGrafico.moverA(posActual, velocidadMovimiento,3);
					break;
				case 4:
					posActual.setX(posActual.getX() - velocidadMovimiento);
					miGrafico.moverA(posActual, velocidadMovimiento,4);
					break;
				case 5:
					posActual.setX(posActual.getX() - velocidadMovimiento);
					posActual.setY(posActual.getY() - velocidadMovimiento);
					miGrafico.moverA(posActual, velocidadMovimiento,5);
					break;
				case 6:
					posActual.setY(posActual.getY() - velocidadMovimiento);
					miGrafico.moverA(posActual, velocidadMovimiento,6);
					break;
				case 7:
					posActual.setX(posActual.getX() + velocidadMovimiento);
					posActual.setY(posActual.getY() - velocidadMovimiento);
					miGrafico.moverA(posActual, velocidadMovimiento,7);
					break;
					
			}
			/*
			if(x1 > x2) { //la Posicion del disparador es mayor que la del disparado en X
				if(y1 > y2) { //la Posicion del disparador es mayor que la del disparado en Y
					posActual.setX(posActual.getX() - velocidadMovimiento);
					posActual.setY(posActual.getY() - velocidadMovimiento);
					miGrafico.moverA(posActual, velocidadMovimiento);  //una vez que me mov� l�gicamente, le digo a mi entidad gr�fica que se mueva
					//ac�, el disparado estaria en el segundo cuadrante de coordenadas
				}
				else { //la posicion del disparado es mayor que la del disparador en Y
					//ac�, el disparado estaria en el tercer cuadrante de coordenadas
					posActual.setX(posActual.getX() - velocidadMovimiento);
					posActual.setY(posActual.getY() + velocidadMovimiento);
					miGrafico.moverA(posActual, velocidadMovimiento);
				}
			}
			else { //la Posicion del disparado es mayor que la del disparador en X
				if(y1 > y2) {
					//ac�, el disparado estaria en el primer cuadrante de coordenadas
					posActual.setX(posActual.getX() + velocidadMovimiento);
					posActual.setY(posActual.getY() - velocidadMovimiento);
					miGrafico.moverA(posActual, velocidadMovimiento);
				}
				else {
					//ac�, el disparado estaria en el cuarto cuadrante de coordenadas
					posActual.setX(posActual.getX() + velocidadMovimiento);
					posActual.setY(posActual.getY() + velocidadMovimiento);
					miGrafico.moverA(posActual, velocidadMovimiento);
				}
			}
			*/
		if(posActual.equals(posFinal)) {
			this.Morir();
		}
	}
	
	public void setPosicion(Posicion p) {
		posActual = p;
	}
	/**
	 * metodo usado para setear la gr�fica cuando sea necesario
	 * @param p posicion inicial de la gr�fica
	 */
	public abstract void setGrafico(Posicion p);
	
	private void Morir() {
		miThread.eliminarProyectil(this);
		miThread = null;
		posActual = null;
		posFinal = null;
		miGrafico.Morir(); //si sali del while es porque llegu� a mi objetivo, le debo decir a mi entidad grafica que se suicide
		miGrafico = null;
	
	}
	//NOTA: asumo que la posicion donde el proyectil apunta hacia derecha es la posicion 1 del sprite y de ahi las demas se calculan siguiendo las agujas del reloj
		/**
		 * metodo que calcula como debe apuntar el sprite
		 * @param x1 coordenada x inicial
		 * @param y1 coordenada y inicial
		 * @param x2 coordenada x destino
		 * @param y2 coordenada y destino
		 * @return numero entre 0 a 7 que ser� usado en el arreglo de sprites
		 */
		private int calcularOrientacion(int x1, int y1, int x2, int y2) {
			int ret = 1; //default
			if(x1 == x2 && y1 != y2){
				if(y1 < y2){ //estoy sobre el eje Y positivo (Recordar que ac� las coordenadas suben para abajo)
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
									ret = 8; //si despues de todo termin� ac�, es porque estoy en la diagonal del primer cuadrante
							}
						}
							
					}
					
				}
			}
			return ret - 1; //le resto 1 para no caerme del arreglo cuando el sprite levante este numero
		}

}