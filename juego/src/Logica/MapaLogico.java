package Logica;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import GUI.MapaVisual;
import Logica.Caminos.*;
import Logica.Niveles.*;
import entidades.Controlable;
import entidades.Enemigo;
import entidades.Objeto;

public class MapaLogico implements MapaLogicoI{
	
	private MapaVisual mapaVisual;
	protected volatile Collection <Controlable> unidadesEnMapa;
	protected volatile Collection <Enemigo> enemigosEnMapa;
	protected volatile Collection <Objeto> objetosEnMapa;
	private static MapaLogico Instancia;
	private Celda [][] matriz;
	private static int tamaño = 20;
	private static int width = 500;
	private static int height = 320;
	private Camino miCamino;
	private Nivel miNivel;
	
	
	/**
	 * constructor : inicializa la matriz de Celdas con un total de (el Ancho del Mapa)/20 por
	 * (alto del Mapa)/20. Usamos 20*20 por el tamaño del Sprite. Luego de inicializar la Matriz
	 * creamos cada Celda perteneciente a la matriz y le enviamos la posicion de su esquina izq.
	 */
	private MapaLogico () {
		matriz = new Celda [width / tamaño] [height / tamaño];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz [0].length; j++) {
				matriz [i][j] = new Celda (i*tamaño,j*tamaño);
			}
		}
		unidadesEnMapa = new CopyOnWriteArrayList <Controlable> ();
		enemigosEnMapa = new CopyOnWriteArrayList <Enemigo> ();
		objetosEnMapa = new CopyOnWriteArrayList <Objeto> ();
		//P = Jugador.InstanciaJugador ();
	}
	
	
	public static MapaLogico InstanciaMapaLogico () {
		if (Instancia == null) {
			Instancia = new MapaLogico ();
		}
		return Instancia;
	}
	
	public void setMapaVisual (MapaVisual MV) {
		this.mapaVisual = MV;
	}
	
	public void setNivel (Nivel miNivel) {
		this.miNivel = miNivel;
		this.miCamino = miNivel.getCamino ();
	}
	
	public MapaVisual getMapaVisual() {
		return mapaVisual;
	}
	
	public Celda getCelda (int X, int Y) {
		Celda C;
		if (posicionValidaEnMapa (X,Y)) {
			C = matriz [X/tamaño] [Y/tamaño];
		}
		else  {
			C = null;
		}
		return C;
	}
	
	public int getTamaño () {
		return tamaño;
	}
	
	public Camino getCamino () {
		return miCamino;
	}
	
	public Nivel getNivel () {
		return miNivel;
	}	
	
	public boolean puedoAgregarControlable (Posicion pos) {
		boolean Puedo;
		if (posicionValidaEnMapa (pos.getX (), pos.getY ()) && noHayControlable(pos)) {
			Puedo = true;
		}
		else {
			Puedo = false;
		}
		return Puedo;
	}
	
	private boolean noHayControlable(Posicion pos) {
		return !miCamino.perteneceAlCamino (pos) && 
				matriz [pos.getX()/20] [pos.getY()/20].getPersonaje () == null;
	}
	
	private boolean hayUnControlable (Posicion pos) {
		return !miCamino.perteneceAlCamino (pos) && 
				matriz [pos.getX()/20] [pos.getY()/20].getPersonaje () != null;
	}
	
	public boolean puedoAgregarObjetoDeTienda (Posicion pos) {
		boolean Puedo;
		if (posicionValidaEnMapa (pos.getX (), pos.getY ()) && hayUnControlable (pos)) {
			Puedo = true;
		}
		else {
			Puedo = false;
		}
		return Puedo;
	}
	
	public void agregarControlable (Controlable c, Posicion pos) {
		if (posicionValidaEnMapa (pos.getX (), pos.getY ())) {
			matriz [pos.getX()/20][pos.getY()/20].addPersonaje (c);
			unidadesEnMapa.add (c);
		}
	}
	
	public void agregarEnemigo (Enemigo e) {
		Posicion pos = e.getPos();
		if (posicionValidaEnMapa (pos.getX (), pos.getY ())) {
			enemigosEnMapa.add (e);
			matriz [pos.getX()/20] [pos.getY()/20].addEnemigo (e);
		}
	}
	
	public void agregarObjeto (Objeto O) {
		Posicion pos = O.getPos ();
		if (posicionValidaEnMapa (pos.getX (), pos.getY ())) {
			objetosEnMapa.add (O);
			matriz [pos.getX()/20] [pos.getY()/20].addObjeto (O);
		}
	}

	public boolean posicionValidaEnMapa (int X, int Y) {
		return X >= 0 && X < width && Y >= 0 && Y < height;
	}
	
	public void eliminarControlable (Controlable C) {
		getCelda (C.getPos ().getX (), C.getPos ().getY ()).EliminarControlableDeCelda (C);
		this.unidadesEnMapa.remove(C);
	}
	
	public void eliminarEnemigo (Enemigo E) {
		getCelda (E.getPos ().getX (), E.getPos ().getY ()).EliminarEnemigoDeCelda (E);
		enemigosEnMapa.remove(E);
		if (enemigosEnMapa.isEmpty () && miNivel.getP().getVida() > 0) {
			miNivel.getTienda().getMarket().setBotonesOff();
			miNivel.Victoria(); //delego la creación del Frame de victoria correspondiente al nivel en el que estoy (si estoy en el útlimo nivel, se creará el frame de FinDelJuego)
		}
	}
	
	public void eliminarObjeto (Objeto O) {
		getCelda (O.getPos ().getX (), O.getPos ().getY ()).EliminarObjetoDeCelda (O);
		objetosEnMapa.remove (O);
	}
	
	public void restarVida () {
		miNivel.getP().restarVida ();
	}
	
	@SuppressWarnings("rawtypes")
	public void interaccionControlableEnemigo () {
		Iterator it = unidadesEnMapa.iterator ();
		Controlable c;
		Enemigo e;
		
		while (it.hasNext ()) {
			c = (Controlable) it.next ();
			if (c != null && c.getPos () != null && !c.estoyEnInteraccion ()) {
				c.setInteraccion (true);
				e = c.verificarUnidad ();
			}
			else {
				e = null;
				c.setInteraccion (false);
			}
			if (e != null && e.estoyEnJuego () && !e.estoyMuerto()) {
				e.serAtacado (c);
				if(e.getEstado().getVida() <= 0) { //pregunto si despues de ser atacado, el enemigo murió
					sacarEnemigo (e);
				}
				if(c.getEstado().getVida() <= 0) { //pregunto si en caso de ser contratacado, el controlable murió
					sacarControlable (c);
				}
				c.setInteraccion (false);
			}
		}
	}
	
	
	private synchronized void sacarEnemigo (Enemigo E) {
		miNivel.murioEnemigo (E);
	}
	
	private synchronized void resetearEnemigos (Enemigo E) {
		miNivel.murioEnemigoSinDrop (E);
	}
	
	private synchronized void sacarControlable (Controlable C) {
		C.morir ();
	}
	
	private synchronized void sacarObjeto (Objeto O) {
		O.Morir ();
	}
	
	/**
	 * método que se encargará de eliminar todo lo que haya quedado en el nivel una vez que el mismo terminó
	 * asumo que no hay más enemigos
	 */
	public void eliminarTodo () {
		Iterator <Controlable> itC = unidadesEnMapa.iterator ();
		Iterator <Objeto> itO = objetosEnMapa.iterator ();
		Iterator <Enemigo> itE = enemigosEnMapa.iterator ();
		
		while (itC.hasNext ()) {
			Controlable C = itC.next ();
			sacarControlable (C);
		}
		unidadesEnMapa.clear ();
		
		if(!enemigosEnMapa.isEmpty()) {
			while(itE.hasNext()) {
				Enemigo E = itE.next();
				resetearEnemigos (E);
			}
		}
		enemigosEnMapa.clear();
		
		while (itO.hasNext ()) {
			Objeto O = itO.next ();
			sacarObjeto (O);
		}
		objetosEnMapa.clear ();
	}
}