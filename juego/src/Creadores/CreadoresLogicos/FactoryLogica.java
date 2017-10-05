package Creadores.CreadoresLogicos;

import entidades.Controlable;

public interface FactoryLogica {
	
	/**
	 * Crea una unidad del jugador en al posicion especificada
	 * @param C Posicion en donde insertar el personaje
	 * @return el nuevo personaje creado
	 * NOTA: Podriamos hacer que el descuento del Oro ocurra directamente aquí, pero tecnicamente NO tengo acceso a la Tienda aquí
	 */
	public Controlable crear ();
	
}