package Logica;

import java.util.Iterator;
import java.util.LinkedList;

public class Camino1Aux implements Camino {
	
	private LinkedList <Posicion> Caminos;
	private LinkedList <Posicion> Fin;
	
	public Camino1Aux () {
		Caminos = new LinkedList <Posicion> ();
		Fin = new LinkedList <Posicion> ();
		generarCamino ();
	}
	
	public void generarCamino () {
		//Inicio Camino A
		Caminos.add (new Posicion (0,0));
		Caminos.add (new Posicion (20,0));
		Caminos.add (new Posicion (20,20));
		Caminos.add (new Posicion (20,40));
		Caminos.add (new Posicion (40,40));
		Caminos.add (new Posicion (60,40));
		Caminos.add (new Posicion (60,60));
		Fin.add (new Posicion (60,60));
		//Fin Camino A
		//Inicio Camino B1
		Caminos.add (new Posicion (80,60));
		Caminos.add (new Posicion (100,60));
		Caminos.add (new Posicion (100,80));
		Caminos.add (new Posicion (120,80));
		Caminos.add (new Posicion (140,80));
		Caminos.add (new Posicion (160,80));
		Caminos.add (new Posicion (180,80));
		Caminos.add (new Posicion (200,80));
		Caminos.add (new Posicion (220,80));
		Caminos.add (new Posicion (240,80));
		Caminos.add (new Posicion (260,80));
		Caminos.add (new Posicion (260,100));
		Caminos.add (new Posicion (280,100));
		Caminos.add (new Posicion (300,100));
		Caminos.add (new Posicion (300,120));
		Caminos.add (new Posicion (320,120));
		Caminos.add (new Posicion (320,140));
		Caminos.add (new Posicion (340,140));
		Fin.add (new Posicion (340,140));
		//Fin Camino B1
		//Inicio Camino B2
		Caminos.add (new Posicion (60,80));
		Caminos.add (new Posicion (60,100));
		Caminos.add (new Posicion (60,120));
		Caminos.add (new Posicion (60,140));
		Caminos.add (new Posicion (60,160));
		Caminos.add (new Posicion (60,180));
		Caminos.add (new Posicion (80,180));
		Caminos.add (new Posicion (100,180));
		Caminos.add (new Posicion (100,200));
		Caminos.add (new Posicion (120,200));
		Caminos.add (new Posicion (140,200));
		Caminos.add (new Posicion (140,220));
		Caminos.add (new Posicion (160,220));
		Caminos.add (new Posicion (160,240));
		Caminos.add (new Posicion (180,240));
		Caminos.add (new Posicion (200,240));
		Caminos.add (new Posicion (220,240));
		Caminos.add (new Posicion (240,240));
		Caminos.add (new Posicion (260,240));
		Caminos.add (new Posicion (280,240));
		Caminos.add (new Posicion (300,240));
		Caminos.add (new Posicion (320,240));
		Caminos.add (new Posicion (340,240));
		Caminos.add (new Posicion (340,220));
		Caminos.add (new Posicion (360,220));
		Caminos.add (new Posicion (360,200));
		Caminos.add (new Posicion (360,180));
		Caminos.add (new Posicion (360,160));
		Fin.add (new Posicion (360,160));
		//Fin Camino B2
		//Inicio Camino C
		Fin.add (new Posicion (360,140));
		Caminos.add (new Posicion (360,140));
		Caminos.add (new Posicion (380,140));
		Caminos.add (new Posicion (400,140));
		Caminos.add (new Posicion (420,140));
		Caminos.add (new Posicion (440,140));
		Caminos.add (new Posicion (460,140));
		Caminos.add (new Posicion (460,160));
		Caminos.add (new Posicion (460,180));
		Caminos.add (new Posicion (460,200));
		Caminos.add (new Posicion (460,220));
		Caminos.add (new Posicion (460,240));
		Caminos.add (new Posicion (460,260));
		//Fin Camino C
		//(460,260) Es Donde Desaparecen Al Llegar Al Castillo
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
	
	public Posicion getNextF (Posicion pos) {
		if (!Fin.isEmpty ()) {
			boolean aviso = false;
			Iterator <Posicion> it = (Iterator <Posicion>) Fin.iterator ();
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
	
	public LinkedList <Posicion> getFin () {
		return Fin;
	}

	public Posicion getPosAleatoria() {
		return null;
	}
}