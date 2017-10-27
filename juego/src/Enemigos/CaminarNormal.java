package Enemigos;

import Logica.Posicion;
import entidades.Enemigo;
import java.util.Random;

public class CaminarNormal implements EstrategiaDeMovimiento {

	private Enemigo e;
	
	public CaminarNormal(Enemigo e) {
		this.e = e;
	}
	
	public void mover () {
		Posicion posSig;
		
		int LastX = e.getMapa ().getCamino ().getCaminoActual ().getLast ().getX ();
		int LastY = e.getMapa ().getCamino ().getCaminoActual ().getLast ().getY ();
		if (e.getPos ().getX () == LastX && e.getPos ().getY () == LastY) {
			Random rand = new Random ();
			int I = rand.nextInt (2) + 1;
			e.getMapa ().getCamino ().cambiarCaminoActual (I);
			posSig = e.getMapa ().getCamino ().getCaminoActual ().getFirst ();
		}
		else {
			posSig = e.getMapa ().getCamino ().getNext (e.getPos ());
		}
		
		//System.out.println ("X: "+e.getPos().getX()+" Y: "+e.getPos().getY());
		//System.out.println ("XSIG: "+posSig.getX()+" YSIG: "+posSig.getY());
		
		e.getMapa ().getCelda (e.getPos ().getX (), e.getPos ().getY ()).EliminarEnemigo (e);
		e.getGrafico ().moverA ((posSig), e.getVelMov ());
		e.getPos ().setX (posSig.getX ());
		e.getPos ().setY (posSig.getY ());
		e.getMapa ().getCelda (posSig.getX(),posSig.getY()).addEnemigo(e);
	}
}