package entidades;

import Logica.Posicion;
import entidades.EntidadesGraficas.objetoGrafico;

public abstract class Proyectil{

	//que tan rápido se mueve el proyectil
	protected int velocidadMovimiento;
	protected objetoGrafico miGrafico;
	protected Posicion posActual;
	protected boolean vivo; //serviria para detectar cuando impactó la bala y matar el proyectil
							//pero dudo de su utilidad
	//el proyectil puede ir en cualquier dirección, eso daria a 8 sprrites distintos que varian en una rotación del sprite inicial (Idle)
	
	
	/**
	 * metodo que le dice al proyectil donde debe viajar 
	 * @param p posicion a donde ir
	 * NOTA: Esto se hace en un contexto lógico
	 */
	public void volarAPosicion(Posicion p){
		while(posActual.getX() != p.getX() && posActual.getY() != p.getY()) {
			int x1 = posActual.getX();
			int y1 = posActual.getY();
			int x2 = p.getX();
			int y2 = p.getY();
			
			//int or = calcularOrientacion(x1,y1,x2,y2);´//1 a 8
			
			if(x1 > x2) { //la Posicion del disparador es mayor que la del disparado en X
				if(y1 > y2) { //la Posicion del disparador es mayor que la del disparado en Y
					posActual.setX(posActual.getX() - velocidadMovimiento);
					posActual.setY(posActual.getY() - velocidadMovimiento);
					miGrafico.moverA(posActual, velocidadMovimiento);  //una vez que me moví lógicamente, le digo a mi entidad gráfica que se mueva
					//acá, el disparado estaria en el segundo cuadrante de coordenadas
				}
				else { //la posicion del disparado es mayor que la del disparador en Y
					//acá, el disparado estaria en el tercer cuadrante de coordenadas
					posActual.setX(posActual.getX() - velocidadMovimiento);
					posActual.setY(posActual.getY() + velocidadMovimiento);
					miGrafico.moverA(posActual, velocidadMovimiento);
				}
			}
			else { //la Posicion del disparado es mayor que la del disparador en X
				if(y1 > y2) {
					//acá, el disparado estaria en el primer cuadrante de coordenadas
					posActual.setX(posActual.getX() + velocidadMovimiento);
					posActual.setY(posActual.getY() - velocidadMovimiento);
					miGrafico.moverA(posActual, velocidadMovimiento);
				}
				else {
					//acá, el disparado estaria en el cuarto cuadrante de coordenadas
					posActual.setX(posActual.getX() + velocidadMovimiento);
					posActual.setY(posActual.getY() + velocidadMovimiento);
					miGrafico.moverA(posActual, velocidadMovimiento);
				}
			}
		}
		
		miGrafico.Morir(); //si sali del while es porque llegué a mi objetivo, le debo decir a mi entidad grafica que se suicide
		
		
	}
	
	public void setPosicion(Posicion p) {
		posActual = p;
	}
	/**
	 * metodo usado para setear la gráfica cuando sea necesario
	 * @param p posicion inicial de la gráfica
	 */
	public abstract void setGrafico(Posicion p);
}
