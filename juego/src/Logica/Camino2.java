package Logica;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class Camino2 implements Camino {
	
	private LinkedList <Posicion> Caminos;
	private LinkedList <Posicion> PosClave;
	
	public Camino2 () {
		Caminos = new LinkedList <Posicion> ();
		PosClave = new LinkedList <Posicion> ();
		generarCamino ();
	}

	public void generarCamino () {
		//Inicio Camino A
		//Fin Camino A
		//Inicio Camino B1
		//Fin Camino B1
		//Inicio Camino B2
		//Fin Camino B2
		//Inicio Camino C
		//Fin Camino C
	}

	public boolean perteneceAlCamino (Posicion pos) {
		boolean Pertenece = false;
		if (!Caminos.isEmpty ()) {
			Iterator <Posicion> it = (Iterator <Posicion>) Caminos.iterator ();
			while (it.hasNext() && !Pertenece) {
				Posicion pos2 = it.next();
				Pertenece = (pos.getX() == pos2.getX() && pos.getY() == pos2.getY()) ;
			}
		}
		return Pertenece;
	}

	public Posicion getNext (Posicion pos) {
		if (!Caminos.isEmpty ()) {
			boolean aviso = false;
			Iterator <Posicion> it = (Iterator <Posicion>) Caminos.iterator ();
			while(it.hasNext ()) {
				if (aviso) { 
					Posicion P = it.next ();
					return new Posicion (P.getX (), P.getY ());
				}
				else {
					Posicion pos2 = it.next ();
					if (pos2.getX () == pos.getX () && pos2.getY () == pos.getY ()) {
						aviso = true;
					}
				}
			}
		}
		return null;
	}

	public Posicion getNextPC (Posicion pos) {
		if (!PosClave.isEmpty ()) {
			boolean aviso = false;
			Iterator <Posicion> it = (Iterator <Posicion>) PosClave.iterator ();
			while(it.hasNext ()) {
				if (aviso) { 
					Posicion P = it.next ();
					return new Posicion (P.getX (), P.getY ());
				}
				else {
					Posicion pos2 = it.next ();
					if (pos2.getX () == pos.getX () && pos2.getY () == pos.getY ()) {
						aviso = true;
					}
				}
			}
		}
		return null;
	}

	public LinkedList <Posicion> getPosClave () {
		return PosClave;
	}
	
	public Posicion getPosAleatoria () {
		Random Rand = new Random ();
		int MaxMov = Rand.nextInt (68) + 1;
		Posicion Objeto = new Posicion (0,0);
		for (int I = 0; I < MaxMov; I++) {
			Objeto = getNext (Objeto);
		}
		return Objeto;
	}
}