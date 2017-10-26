package Logica;

import java.util.Iterator;
import java.util.LinkedList;

public class Camino1Aux implements Camino {
	
	private LinkedList <Posicion> [] Caminos;
	private LinkedList <Posicion> CaminoActual;
	private int Cantidad;
	
	@SuppressWarnings("unchecked")
	public Camino1Aux () {
		Caminos = new LinkedList [3];
		for (int I = 0; I < 3; I++) {
			Caminos [I] = new LinkedList <Posicion> ();
		}
		CaminoActual = Caminos [0];
		generarCaminoA ();
		generarCaminoB1 ();
		generarCaminoB2 ();
	}

	public void generarCaminoA () {
		Caminos [0].add (new Posicion (0,0));
		Caminos [0].add (new Posicion (20,0));
		Caminos [0].add (new Posicion (20,20));
		Caminos [0].add (new Posicion (20,40));
		Caminos [0].add (new Posicion (40,40));
		Caminos [0].add (new Posicion (60,40));
		Caminos [0].add (new Posicion (60,60));
	}
	
	public void generarCaminoB1 () {
		Caminos [1].add (new Posicion (80,60));
		//Caminos [1].add (new Posicion (100,60)); si descomento este camino, se para cuando va a la derecha
		Caminos [1].add (new Posicion (100,80));
		Caminos [1].add (new Posicion (120,80));
		Caminos [1].add (new Posicion (140,80));
		Caminos [1].add (new Posicion (160,80));
		Caminos [1].add (new Posicion (180,80));
		Caminos [1].add (new Posicion (200,80));
		Caminos [1].add (new Posicion (220,80));
		Caminos [1].add (new Posicion (240,80));
		Caminos [1].add (new Posicion (260,80));
		Caminos [1].add (new Posicion (260,100));
		Caminos [1].add (new Posicion (280,100));
		Caminos [1].add (new Posicion (300,100));
		Caminos [1].add (new Posicion (300,120));
		Caminos [1].add (new Posicion (320,120));
		Caminos [1].add (new Posicion (320,140));
		Caminos [1].add (new Posicion (340,140));
		Caminos [1].add (new Posicion (360,140));
		Caminos [1].add (new Posicion (380,140));
		Caminos [1].add (new Posicion (400,140));
		Caminos [1].add (new Posicion (420,140));
		Caminos [1].add (new Posicion (440,140));
		Caminos [1].add (new Posicion (460,140));
		Caminos [1].add (new Posicion (460,160));
		Caminos [1].add (new Posicion (460,180));
		Caminos [1].add (new Posicion (460,200));
		Caminos [1].add (new Posicion (460,220));
		Caminos [1].add (new Posicion (460,240));
		Caminos [1].add (new Posicion (460,260));
	}
	
	public void generarCaminoB2 () {
		Caminos [2].add (new Posicion (60,80));
		Caminos [2].add (new Posicion (60,100)); //si comento esto
		Caminos [2].add (new Posicion (60,120)); //y cambio X por 80
		Caminos [2].add (new Posicion (60,140)); //aca tambien por 80
		Caminos [2].add (new Posicion (60,160)); //y aca tambien por 80 entonces llega al final
		Caminos [2].add (new Posicion (60,180));
		Caminos [2].add (new Posicion (80,180));
		Caminos [2].add (new Posicion (100,180));
		Caminos [2].add (new Posicion (100,200));
		Caminos [2].add (new Posicion (120,200));
		Caminos [2].add (new Posicion (140,200));
		Caminos [2].add (new Posicion (140,220));
		Caminos [2].add (new Posicion (160,220));
		Caminos [2].add (new Posicion (160,240));
		Caminos [2].add (new Posicion (180,240));
		Caminos [2].add (new Posicion (200,240));
		Caminos [2].add (new Posicion (220,240));
		Caminos [2].add (new Posicion (240,240));
		Caminos [2].add (new Posicion (260,240));
		Caminos [2].add (new Posicion (280,240));
		Caminos [2].add (new Posicion (300,240));
		Caminos [2].add (new Posicion (320,240));
		Caminos [2].add (new Posicion (340,240));
		Caminos [2].add (new Posicion (340,220));
		Caminos [2].add (new Posicion (360,220));
		Caminos [2].add (new Posicion (360,200));
		Caminos [2].add (new Posicion (360,180));
		Caminos [2].add (new Posicion (360,160));
		Caminos [2].add (new Posicion (360,140));
		Caminos [2].add (new Posicion (380,140));
		Caminos [2].add (new Posicion (400,140));
		Caminos [2].add (new Posicion (420,140));
		Caminos [2].add (new Posicion (440,140));
		Caminos [2].add (new Posicion (460,140));
		Caminos [2].add (new Posicion (460,160));
		Caminos [2].add (new Posicion (460,180));
		Caminos [2].add (new Posicion (460,200));
		Caminos [2].add (new Posicion (460,220));
		Caminos [2].add (new Posicion (460,240));
		Caminos [2].add (new Posicion (460,260));
	}

	public boolean perteneceAlCamino (Posicion pos) {
		boolean Pertenece = false;
		if (!CaminoActual.isEmpty ()) {
			Iterator <Posicion> it = (Iterator <Posicion>) CaminoActual.iterator ();
			while (it.hasNext() && !Pertenece) {
				Posicion pos2 = it.next();
				Pertenece = (pos.getX() == pos2.getX() && pos.getY() == pos2.getY()) ;
			}
		}
		return Pertenece;
	}

	public Posicion getNext (Posicion pos) {
		if (!CaminoActual.isEmpty ()) {
			boolean aviso = false;
			Iterator <Posicion> it = (Iterator <Posicion>) CaminoActual.iterator ();
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
	
	public LinkedList <Posicion> [] getCamino () {
		return Caminos;
	}
	
	public LinkedList <Posicion> getCaminoActual () {
		return CaminoActual;
	}
	
	public void cambiarCaminoActual (int I) {
		CaminoActual = Caminos [I];
	}
	
	public int getCantidad () {
		return Cantidad;
	}
}