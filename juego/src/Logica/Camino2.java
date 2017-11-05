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
		PosClave.add (new Posicion (0,40));
		Caminos.add (new Posicion (0,40));
		Caminos.add (new Posicion (20,40));
		Caminos.add (new Posicion (40,40));
		Caminos.add (new Posicion (60,40));
		Caminos.add (new Posicion (80,40));
		Caminos.add (new Posicion (100,40));
		Caminos.add (new Posicion (180,40));
		Caminos.add (new Posicion (200,40));
		Caminos.add (new Posicion (240,40));
		Caminos.add (new Posicion (260,40));
		Caminos.add (new Posicion (280,40));
		PosClave.add (new Posicion (280,40));
		//Fin Camino A
		//Inicio Camino B1
		PosClave.add (new Posicion (280,20));
		Caminos.add (new Posicion (280,20));
		Caminos.add (new Posicion (280,0));
		Caminos.add (new Posicion (300,0));
		Caminos.add (new Posicion (320,0));
		Caminos.add (new Posicion (340,0));
		Caminos.add (new Posicion (360,0));
		Caminos.add (new Posicion (360,20));
		Caminos.add (new Posicion (360,40));
		Caminos.add (new Posicion (360,60));
		Caminos.add (new Posicion (380,60));
		Caminos.add (new Posicion (400,60));
		Caminos.add (new Posicion (400,80));
		Caminos.add (new Posicion (400,100));
		Caminos.add (new Posicion (400,120));
		Caminos.add (new Posicion (400,140));
		Caminos.add (new Posicion (400,160));
		Caminos.add (new Posicion (420,160));
		Caminos.add (new Posicion (440,160));
		PosClave.add (new Posicion (440,160));
		//Fin Camino B1
		//Inicio Camino B2
		PosClave.add (new Posicion (280,60));
		Caminos.add (new Posicion (280,60));
		Caminos.add (new Posicion (280,80));
		Caminos.add (new Posicion (300,80));
		Caminos.add (new Posicion (300,100));
		Caminos.add (new Posicion (320,100));
		Caminos.add (new Posicion (320,120));
		Caminos.add (new Posicion (340,120));
		Caminos.add (new Posicion (340,140));
		Caminos.add (new Posicion (360,140));
		Caminos.add (new Posicion (360,160));
		Caminos.add (new Posicion (380,160));
		Caminos.add (new Posicion (380,180));
		Caminos.add (new Posicion (380,200));
		Caminos.add (new Posicion (380,220));
		Caminos.add (new Posicion (400,220));
		Caminos.add (new Posicion (420,220));
		Caminos.add (new Posicion (440,220));
		Caminos.add (new Posicion (460,220));
		Caminos.add (new Posicion (460,200));
		Caminos.add (new Posicion (460,180));
		PosClave.add (new Posicion (460,180));
		//Fin Camino B2
		//Inicio Camino C
		PosClave.add (new Posicion (460,160));
		Caminos.add (new Posicion (460,160));
		Caminos.add (new Posicion (460,140));
		Caminos.add (new Posicion (460,120));
		Caminos.add (new Posicion (460,100));
		PosClave.add (new Posicion (460,100));
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