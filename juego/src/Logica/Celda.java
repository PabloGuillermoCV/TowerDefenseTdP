package Logica;

import entidades.*;
import java.util.*;

public class Celda {
	private LinkedList <Enemigo> enemigos;
	private Controlable personaje;
	private Posicion esquinaIzq;
	private MapaLogico mapa;
	
	public Celda (int x, int y,MapaLogico mapa) {
		esquinaIzq = new Posicion(x*20,y*20);
		enemigos = new LinkedList<Enemigo>();
		this.mapa = mapa;
		personaje = null;
	}
	
	public void addEnemigo (Enemigo E) {
		enemigos.addLast(E);
	}
	
	public void addPersonaje (Controlable C){
		personaje = C;
	}
	
	public void addObjeto (Conceptual C) {
		personaje.setPowerUpComprado (C);
	}
	
	public LinkedList<Enemigo> getEnemigos(){
		return enemigos;
	}
	
	public Controlable getPersonaje() {
		return personaje;
	}
	
	public Posicion getEsquinaIzq () {
		return esquinaIzq;
	}
	
	public MapaLogico getMapa () {
		return mapa;
	}
}