package Enemigos;
import Logica.Posicion;

public interface Movimiento {
	
	/**
	 * el metodo moverA , deberia implementarse de la misma manera que implementamos el metodo
	 * moverA del Soldado que implementamos para el segundo Sprint. La idea de tenerlo como 
	 * interfaz y que cada uno lo reedefina hace que cada uno se pueda mover de manera diferente.
	 * @param pos recibe la Posicion de destino
	 */
	public void moverA(Posicion pos);
	
	/**
	 * este metodo seria muy Similar al de arriba, solo que seria un movimiento mas lento
	 * y se daria por ejemplo cuando un enemigo va a una celda destino la cual tiene un Lago.
	 * @param pos Recibe la Posicion de destino
	 */
	
	public void moverAlentizados (Posicion pos);

}
