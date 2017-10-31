package Creadores.CreadoresLogicos;

import Logica.Posicion;
import entidades.Controlable;
import Objetos.ObjsDeLaTienda.ObjDeLaTienda;

public interface FactoryLogica {
	
	/**
	 * Crea una unidad del jugador en al posicion especificada
	 * @param C Posicion en donde insertar el personaje
	 * @return el nuevo personaje creado
	 * NOTA: Podriamos hacer que el descuento del Oro ocurra directamente aquí, pero tecnicamente NO tengo acceso a la Tienda aquí
	 */
	public Controlable crearCont (Posicion pos);
	
	public ObjDeLaTienda crearObj (Posicion pos);
	
	public int getCosto ();
}