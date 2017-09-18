package Logica;


import entidades.*;
import java.util.*;


public class Celda {
	private ArrayList<enemigo> enemigos;
	private Controlable personaje;
	private Posicion esquinaIzq;
	private MapaLogico mapa;
	
	public Celda (int x, int y,MapaLogico mapa) {
		esquinaIzq = new Posicion(x*20,y*20);
		enemigos = new ArrayList<enemigo>();
		this.mapa=mapa;
		
	}
	
	
	
	public ArrayList<enemigo> getEnemigos(){
		return enemigos;
	}
	public Controlable getPersonaje() {
		return personaje;
	}
}
