package Enemigos;

import entidades.*;
import Logica.Posicion;

public class CaminarMermado implements EstrategiaDeMovimiento {

	private Enemigo e;
	
	public CaminarMermado (Enemigo e) {
		this.e = e;
	}
	
	/**
	 * metodo que, asumiendo que el personaje esta en el rio, 
	 * hace que se mueva a la mitad de la velocidad
	 * @param pos posicion a la que se moverá el enemigo
	 */
	public void moverA (Posicion pos) {
		e.getMapa ().getCelda (pos.getX(),pos.getY()).EliminarEnemigo(e);
		e.getGrafico ().moverA (pos, 2);
		e.getPos ().setX (pos.getX ());
		e.getPos ().setY (pos.getY ());
		e.getMapa ().getCelda (pos.getX(),pos.getY()).addEnemigo(e);
	}
}