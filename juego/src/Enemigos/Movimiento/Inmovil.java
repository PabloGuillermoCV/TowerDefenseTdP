package Enemigos.Movimiento;

import java.util.Random;

import Logica.Celda;
import Logica.Posicion;
import entidades.Enemigo;

public class Inmovil implements EstrategiaDeMovimiento {
	
	private Enemigo e;
	
	public Inmovil (Enemigo e) {
		this.e = e;
	}

	public void mover () {
		e.setAfectado(false);
		if (!e.estoyMuerto()) {
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
			
			
			
			Posicion p = e.getMapa().getCamino().getNext(e.getPos());
			Celda c = e.getMapa().getCelda(p.getX(),p.getY());
			//pregunto si la roca que tenia adelante ya fue "vencida" y si es asi vuelvo a caminarnormal
			if(c.getObjeto()==null) {
				e.setEstrategia(new CaminarNormal(e));
			}
			else { c.getObjeto().Afectar(e);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
			}
	}
}