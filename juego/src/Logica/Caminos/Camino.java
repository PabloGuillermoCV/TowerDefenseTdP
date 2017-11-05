package Logica.Caminos;

import java.util.LinkedList;
import Logica.Posicion;

public interface Camino {
	
	/**
	 * Metodo que se encarca de crear el camino entero que va a recorrer el enemigo
	 */
	public void generarCamino ();
	
	/**
	 * Metodo que verifica si una posicion pertenece al camino del enemigo
	 * @param pos La Posicion a verificar
	 * @return boolean Verdadero si pertenece y falso en caso contrario
	 */
	public boolean perteneceAlCamino (Posicion pos);
	
	/**
	 * Metodo que retorna la siguiente posicion en la lista de posiciones del camino
	 * @param pos Una Posicion perteneciente al camino
	 * @return Posicion La siguiente Posicion que le sigue a la pasada por parametro
	 */
	public Posicion getNext (Posicion pos);
	
	/**
	 * Metodo que retorna la siguiente Posicion de la lista de posiciones clave del camino
	 * @param pos Una Posicion perteneciente al camino
	 * @return Posicion La siguiente Posicion que le sigue a la pasada por parametro
	 */
	public Posicion getNextPC (Posicion pos);
	
	/**
	 * Metodo que retorna una lista con posiciones claves del camino
	 * @return LinkedList <Posicion> La lista con las posiciones importantes
	 */
	public LinkedList <Posicion> getPosClave ();
	
	/**
	 * Metodo que  devuelve una posición aleatoria del camino donde se insertará un elemento de mapa
	 * @return Posicion Una Posicion que perteneciente al camino
	 */
	public Posicion getPosAleatoria ();
}