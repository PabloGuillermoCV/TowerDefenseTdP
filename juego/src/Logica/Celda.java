package Logica;


import entidades.*;
import java.util.*;


public class Celda {
	private LinkedList<enemigo> enemigos;
	private Controlable personaje;
	@SuppressWarnings("unused")
	private Posicion esquinaIzq;
	@SuppressWarnings("unused")
	private MapaLogico mapa;
	
	public Celda (int x, int y,MapaLogico mapa) {
		esquinaIzq = new Posicion(x*20,y*20);
		enemigos = new LinkedList<enemigo>();
		this.mapa=mapa;
		
	}
	
	
	
	public LinkedList<enemigo> getEnemigos(){
		return enemigos;
	}
	public Controlable getPersonaje() {
		return personaje;
	}
}
