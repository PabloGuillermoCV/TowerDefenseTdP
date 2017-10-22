package Enemigos;

import Logica.Posicion;
import entidades.Enemigo;

public class CaminarDa�ado implements EstrategiaDeMovimiento {

	private Enemigo e;
	
	public CaminarDa�ado(Enemigo e) {
		this.e = e;
	}
	
	/**
	 * metodo que, asuminedo que el enemigo esta en un campo da�ino,
	 * le saca 5 de vida cada vez que se mueve
	 * @param pos la posicion donde se mover� el enemigo
	 */
	public void mover () {
		Posicion posSig= e.getMapa().getCamino().getNext(e.getPos());
		e.getMapa ().getCelda (e.getPos()).EliminarEnemigo(e);
		e.getGrafico ().moverA ((posSig), e.getVelMov ());
		e.getPos ().setX (posSig.getX());
		e.getPos ().setY (posSig.getY ());
		e.getMapa ().getCelda (posSig).addEnemigo(e);
		afectarVida ();
	}
	
	private void afectarVida () {
		int Porc = (e.getEstado().getVida () * 10) / 100;
		e.getEstado().setVida (e.getEstado().getVida () - Porc);
	}
}