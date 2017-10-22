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
	public void mover(){
		Posicion posSig= e.getMapa().getCamino().getNext(e.getPos());
		e.getMapa ().getCelda (e.getPos()).EliminarEnemigo(e);
		e.getGrafico ().moverA ((posSig), 2);
		e.getPos ().setX (posSig.getX());
		e.getPos ().setY (posSig.getY ());
		e.getMapa ().getCelda (posSig).addEnemigo(e);
	}
}