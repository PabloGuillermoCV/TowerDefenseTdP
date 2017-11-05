package Logica;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class Camino3 implements Camino {
	
	private LinkedList <Posicion> Caminos;
	private LinkedList <Posicion> PosClave;
	
	public Camino3 () {
		Caminos = new LinkedList <Posicion> ();
		PosClave = new LinkedList <Posicion> ();
		generarCamino ();
	}

	public void generarCamino () {
		//Inicio Camino A
		PosClave.add (new Posicion (440,300));
		Caminos.add (new Posicion (440,300));
		Caminos.add (new Posicion (440,280));
		Caminos.add (new Posicion (440,260));
		Caminos.add (new Posicion (420,260));
		Caminos.add (new Posicion (400,260));
		Caminos.add (new Posicion (380,260));
		Caminos.add (new Posicion (380,240));
		Caminos.add (new Posicion (360,240));
		PosClave.add (new Posicion (360,240));
		//Fin Camino A
		//Inicio Camino B1
		PosClave.add (new Posicion (360,220));
		Caminos.add (new Posicion (360,220));
		Caminos.add (new Posicion (360,200));
		Caminos.add (new Posicion (360,180));
		Caminos.add (new Posicion (360,160));
		Caminos.add (new Posicion (360,140));
		Caminos.add (new Posicion (360,120));
		Caminos.add (new Posicion (340,120));
		Caminos.add (new Posicion (320,120));
		Caminos.add (new Posicion (300,120));
		Caminos.add (new Posicion (300,100));
		Caminos.add (new Posicion (300,80));
		Caminos.add (new Posicion (300,60));
		Caminos.add (new Posicion (280,60));
		Caminos.add (new Posicion (260,60));
		Caminos.add (new Posicion (240,60));
		Caminos.add (new Posicion (220,60));
		Caminos.add (new Posicion (220,80));
		Caminos.add (new Posicion (220,100));
		Caminos.add (new Posicion (220,120));
		PosClave.add (new Posicion (220,120));
		//Fin Camino B1
		//Inicio Camino B2
		PosClave.add (new Posicion (340,240));
		Caminos.add (new Posicion (340,240));
		Caminos.add (new Posicion (320,240));
		Caminos.add (new Posicion (300,240));
		Caminos.add (new Posicion (280,240));
		Caminos.add (new Posicion (260,240));
		Caminos.add (new Posicion (240,240));
		Caminos.add (new Posicion (220,240));
		Caminos.add (new Posicion (200,240));
		Caminos.add (new Posicion (200,220));
		Caminos.add (new Posicion (200,200));
		Caminos.add (new Posicion (180,200));
		Caminos.add (new Posicion (160,200));
		Caminos.add (new Posicion (160,180));
		Caminos.add (new Posicion (160,160));
		Caminos.add (new Posicion (160,140));
		Caminos.add (new Posicion (180,140));
		Caminos.add (new Posicion (200,140));
		PosClave.add (new Posicion (200,140));
		//Fin Camino B2
		//Inicio Camino C
		PosClave.add (new Posicion (200,120));
		Caminos.add (new Posicion (200,120));
		Caminos.add (new Posicion (180,120));
		Caminos.add (new Posicion (160,120));
		Caminos.add (new Posicion (140,120));
		PosClave.add (new Posicion (140,120));
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