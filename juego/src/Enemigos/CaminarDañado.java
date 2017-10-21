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
	public void moverA (Posicion pos) {
		e.getMapa ().getCelda (pos.getX(),pos.getY()).EliminarEnemigo(e);
		e.getGrafico ().moverA (pos, e.getVelMov ());
		e.getPos ().setX (pos.getX ());
		e.getPos ().setY (pos.getY ());
		e.getMapa ().getCelda (pos.getX(),pos.getY()).addEnemigo(e);
		afectarVida ();
	}
	
	private void afectarVida () {
		int Porc = (e.getEstado().getVida () * 10) / 100;
		e.getEstado().setVida (e.getEstado().getVida () - Porc);
	}
}