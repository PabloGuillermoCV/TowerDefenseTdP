package Logica;

import java.util.*;
import entidades.*;

public class Celda {
	private Controlable personaje;
	private volatile LinkedList <Enemigo> enemigos;
	private Objeto objeto;
	private Posicion esquinaIzq;
	private static MapaLogico mapa = MapaLogico.InstanciaMapaLogico ();
	
	/**
	 * Constructor : recibe el x e y que son las coordenadas de la esquina izquierda
	 */
	public Celda (int x, int y) {
		esquinaIzq = new Posicion (x,y);
		personaje = null;
		enemigos = new LinkedList <Enemigo> ();
	}
	
	public void addEnemigo (Enemigo e) {
		enemigos.addLast (e);
	}
	
	public void addPersonaje (Controlable c) {
		if (personaje == null) {
			personaje = c;
		}
	}
	
	public void addObjeto (Objeto o) {
		objeto = o;
	}
	
	public LinkedList <Enemigo> getEnemigos () {
		return enemigos;
	}
	
	public Controlable getPersonaje () {
		return personaje;
	}
	
	public Objeto getObjeto () {
		return objeto;
	}
	
	public Posicion getEsquinaIzq () {
		return esquinaIzq;
	}
	
	public MapaLogico getMapa () {
		return mapa;
	}
	
	public void EliminarControlableDeCelda (Controlable c) {
		if (c == personaje) {
			personaje = null;
		}
	}
	
	public void EliminarEnemigoDeCelda (Enemigo e) {
		if (enemigos.contains (e)) {
			enemigos.remove (e);
		}
	}
	
	public void EliminarObjetoDeCelda (Objeto O) {
		if (O == objeto) {
			objeto = null;
		}
	}
}