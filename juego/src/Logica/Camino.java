package Logica;

import java.util.LinkedList;

public interface Camino {
	/**
	 *  Metodo que se encarca de crear el camino y guardarlo como un atributo de instancia
	 * @param pos recibe la posicion final de la base Aliada(osea donde deber terminar los enem) 
	 * 
	 */
	public void generarCaminoA ();
	
	
	public boolean perteneceAlCamino (Posicion pos);
	
	/**
	 * 
	 * @param pos una Posicion perteneciente al camino
	 * @return la siguiente posicion que le sigue a la pasada por parametro
	 */
	public Posicion getNext (Posicion pos);
	
	public LinkedList <Posicion> [] getCamino ();
	
	public LinkedList <Posicion> getCaminoActual ();
	
	public void cambiarCaminoActual (int I);
	
	public int getCantidad () ;
}
