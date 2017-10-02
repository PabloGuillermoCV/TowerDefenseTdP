package Logica;


import java.util.*;

import entidades.*;
import Objetos.*;

public class Celda {
	private LinkedList<Enemigo> enemigos;
	private Controlable personaje;
	// podria ser en vez de una lista de objetos un solo objeto noMas
	private LinkedList<ObjDentroDelMapa> objetos;
	private Posicion esquinaIzq;
	private MapaLogico mapa;
	
	/**
	 * Constructor : recibe el x e y que son las coordenadas de la esquina izquierda y el
	 * mapa al que pertenece.
	 */
	
	public Celda (int x, int y,MapaLogico mapa) {
		esquinaIzq = new Posicion(x,y);
		enemigos = new LinkedList<Enemigo>();
		this.mapa = mapa;
		personaje = null;
	}
	
	
	public void addEnemigo (Enemigo e) {
		enemigos.addLast(e);
	}
	
	public void addPersonaje (Controlable c){
		personaje = c;
	}
	/**
	public void addObjeto (Conceptual o) {
		personaje.setPowerUpComprado (o);
	}
	**/
	
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