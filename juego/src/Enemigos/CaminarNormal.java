package Enemigos;

import Logica.Posicion;
import entidades.Enemigo;

public class CaminarNormal implements EstrategiaDeMovimiento {

	private Enemigo e;
	
	public CaminarNormal(Enemigo e) {
		this.e = e;
	}
	
	public void moverA (Posicion pos) {
		e.getMapa ().getCelda (pos.getX(),pos.getY()).EliminarEnemigo(e);
		e.getGrafico ().moverA (pos, e.getVelMov ());
		e.getPos ().setX (pos.getX ());
		e.getPos ().setY (pos.getY ());
		e.getMapa ().getCelda (pos.getX(),pos.getY()).addEnemigo(e);
	}
}