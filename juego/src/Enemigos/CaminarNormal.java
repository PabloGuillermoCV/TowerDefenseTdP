package Enemigos;

import Logica.Posicion;
import entidades.Enemigo;

public class CaminarNormal implements EstrategiaDeMovimiento {

	private Enemigo e;
	
	public CaminarNormal(Enemigo e) {
		this.e = e;
	}
	
	public void mover() {
		Posicion posSig= e.getMapa().getCamino().getNext(e.getPos());
		e.getMapa ().getCelda (e.getPos().getX(), e.getPos().getY()).EliminarEnemigo(e);
		e.getGrafico ().moverA ((posSig), e.getVelMov ());
		e.getPos ().setX (posSig.getX());
		e.getPos ().setY (posSig.getY ());
		e.getMapa ().getCelda (posSig.getX(),posSig.getY()).addEnemigo(e);
	}
}