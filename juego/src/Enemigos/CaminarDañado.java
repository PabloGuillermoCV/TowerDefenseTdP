package Enemigos;

import Logica.Posicion;
import entidades.Enemigo;
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
		Posicion AI = e.getMapa ().getCamino ().getPosClave ().getFirst(); //Posicion de inicio de enemigos
		Posicion AF = e.getMapa ().getCamino ().getNextPC (AI); //Posicion de la separacion en rutas
		Posicion B1I = e.getMapa ().getCamino ().getNextPC (AF); //Posicion inicio de ruta 1
		Posicion B1F = e.getMapa ().getCamino ().getNextPC (B1I); //Posicion final de ruta 1
		Posicion B2I = e.getMapa ().getCamino ().getNextPC (B1F); //Posicion inicio de ruta 2
		Posicion B2F = e.getMapa ().getCamino ().getNextPC (B2I); //Posicion final de ruta 2
		Posicion CI = e.getMapa ().getCamino ().getNextPC (B2F); //Posicion de inicio de la interseccion
		Posicion CF = e.getMapa ().getCamino ().getNextPC (CI); //Posicion del castillo
		
		if (e.getPos ().getX () == AF.getX () && e.getPos ().getY () == AF.getY ()) {
			//Llego a la interseccion y elijo uno de los dos caminos
			Random Rand = new Random ();
			int I = Rand.nextInt (2) + 1; //Random entre 1 y 2
			if (I == 1) {
				//Paso a la ruta 1
				posSig = new Posicion (B1I.getX (), B1I.getY ());
			}
			else {
				//Paso a la ruta 2
				posSig = new Posicion (B2I.getX (), B2I.getY ());
			}
		}
		
		else {
			if ((e.getPos ().getX () == B1F.getX () && e.getPos ().getY () == B1F.getY ())
			|| (e.getPos ().getX() == B2F.getX () && e.getPos ().getY() == B2F.getY ())) {
				//Las intersecciones se unen para llegar directo al castillo
				posSig = new Posicion (CI.getX (), CI.getY ());
			}
			else {
				//Me muevo normal
				posSig = e.getMapa ().getCamino ().getNext (e.getPos ());
			}
		}
		
		if (posSig.getX () == CF.getX () && posSig.getY () == CF.getY ()) {
			//Aca se borra el enemigo del mapa ya que llego al final
			posSig = null;
			e.morirEnCastillo ();
		}
		
		if (posSig != null) {
			e.getMapa ().getCelda (e.getPos ().getX (), e.getPos ().getY ()).EliminarEnemigoDeCelda (e);
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