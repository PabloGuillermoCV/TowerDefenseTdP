package Enemigos;

import Logica.Posicion;
import entidades.Enemigo;
import java.util.LinkedList;
import java.util.Random;

public class CaminarDañado implements EstrategiaDeMovimiento {

	private Enemigo e;
	
	public CaminarDañado (Enemigo e) {
		this.e = e;
	}
	
	/**
	 * metodo que, asuminedo que el enemigo esta en un campo dañino,
	 * le saca 5 de vida cada vez que se mueve
	 * @param pos la posicion donde se moverá el enemigo
	 */
	public void mover () {
		Posicion posSig;
		LinkedList <Posicion> FinCamino = e.getMapa ().getCamino ().getPosClave ();
		Posicion A = FinCamino.getFirst(); //Posicion de la separacion en rutas
		Posicion B1 = e.getMapa ().getCamino ().getNextPC (A); //Posicion final de ruta 1
		Posicion B2 = e.getMapa ().getCamino ().getNextPC (B1); //Posicion final de ruta 2
		Posicion C = e.getMapa ().getCamino ().getNextPC (B2); //Posicion de inicio de la interseccion
		
		if (e.getPos ().getX () == A.getX () && e.getPos ().getY () == A.getY ()) {
			//Llego a la interseccion y elijo uno de los dos caminos
			Random Rand = new Random ();
			int I = Rand.nextInt (2) + 1; //Random entre 1 y 2
			if (I == 1) {
				//Paso a la ruta 1
				posSig = new Posicion (A.getX () + 20, A.getY ());
			}
			else {
				//Paso a la ruta 2
				posSig = new Posicion (A.getX (), A.getY () + 20);
			}
		}
		
		else {
			if ((e.getPos ().getX () == B1.getX () && e.getPos ().getY () == B1.getY ())
			|| (e.getPos ().getX() == B2.getX () && e.getPos ().getY() == B2.getY ())) {
				//Las intersecciones se unen para llegar directo al castillo
				posSig = new Posicion (C.getX (), C.getY ());
			}
			else {
				//Me muevo normal
				posSig = e.getMapa ().getCamino ().getNext (e.getPos ());
			}
		}
		
		if (posSig.getX () == 0 && posSig.getY () == 0) {
			//Aca se borra el enemigo del mapa ya que llego al final
			posSig = null;
			e.morir ();
		}
		
		//Posicion posSig = e.getMapa ().getCamino ().getNext (e.getPos ());
		if (posSig != null) {
			e.getMapa ().getCelda (e.getPos ().getX (), e.getPos ().getY ()).EliminarEnemigo (e);
			e.getGrafico ().moverA (posSig, e.getVelMov ());
			e.getPos ().setX (posSig.getX ());
			e.getPos ().setY (posSig.getY ());
			e.getMapa ().getCelda (posSig.getX (), posSig.getY ()).addEnemigo (e);
			afectarVida ();
		}
	}
	
	private void afectarVida () {
		int Porc = (e.getEstado ().getVida () * 10) / 100;
		e.getEstado ().setVida (e.getEstado ().getVida () - Porc);
	}
}