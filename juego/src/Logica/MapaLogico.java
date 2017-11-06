package Logica;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import GUI.MapaVisual;
import Logica.Caminos.*;
import Logica.Niveles.*;
import Objetos.ObjResistente.CampoDeDaño;
import Objetos.ObjResistente.Roca;
import Objetos.ObjTemporal.CampoDebilitador;
import Objetos.ObjTemporal.Lago;
import entidades.Controlable;
import entidades.Enemigo;
import entidades.Objeto;

public class MapaLogico {
	
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
	private Jugador P;
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
		unidadesEnMapa = new LinkedList <Controlable> ();
		enemigosEnMapa = new LinkedList <Enemigo> ();
		objetosEnMapa = new LinkedList <Objeto> ();
		P = Jugador.InstanciaJugador ();
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
		if (posicionValida (X,Y)) {
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
	
	public Jugador getJugador () {
		return P;
	}
	
	public Nivel getNivel () {
		return miNivel;
	}

	public Collection <Controlable> getListaControlables () {
		return unidadesEnMapa;
	}

	public Collection <Enemigo> getListaEnemigos () {
		return enemigosEnMapa;
	}
	
	public Collection <Objeto> getListaObjetos () {
		return objetosEnMapa;
	}
	
	public boolean puedoAgregarControlable (Posicion pos) {
		boolean Puedo;
		if (posicionValida (pos.getX (), pos.getY ()) && !miCamino.perteneceAlCamino (pos) && 
			matriz[pos.getX()/20][pos.getY()/20].getPersonaje() == null) {
			Puedo = true;
		}
		else {
			Puedo = false;
		}
		return Puedo;
	}
	
	public boolean puedoAgregarObjetoDeTienda (Posicion pos) {
		boolean Puedo;
		if (posicionValida (pos.getX(), pos.getY()) && !miCamino.perteneceAlCamino(pos) && 
			matriz[pos.getX()/20][pos.getY()/20].getPersonaje() != null) {
			Puedo = true;
		}
		else {
			Puedo = false;
		}
		return Puedo;
	}
	
	public void agregarControlable (Controlable c, Posicion pos) {
		if (posicionValida (pos.getX (), pos.getY ())) {
			matriz [pos.getX()/20][pos.getY()/20].addPersonaje (c);
			unidadesEnMapa.add (c);
		}
	}
	
	public void agregarEnemigo (Enemigo e) {
		Posicion pos = e.getPos();
		if (posicionValida (pos.getX (), pos.getY ())) {
			enemigosEnMapa.add (e);
			matriz [pos.getX()/20] [pos.getY()/20].addEnemigo (e);
		}
	}
	
	public void agregarObjeto (Objeto O) {
		Posicion pos = O.getPos ();
		if (posicionValida (pos.getX (), pos.getY ())) {
			objetosEnMapa.add (O);
			matriz [pos.getX()/20] [pos.getY()/20].addObjeto (O);
		}
	}

	public boolean posicionValida (int X, int Y) {
		return X >= 0 && X < width && Y >= 0 && Y < height;
	}
	
	/**
	 * metodo que se encarga de, usando un Random, generar un objeto de mapa
	 * (Lago,campo dañino, etc) y tirarlo en alguna posición del Camino de enemigos
	 * El MapaVisual debria tener un metodo similar que lo que haga es, 
	 * recibiendo el item especifico, lo muestre en el mapa donde debe
	 *  podemos usar el Thread "Contador Tiempo" para contar el tiempo que dura el objeto
	 *  lo que hace ese Thread es mantener un contador y le va sumando 1 por cada segundo que pasa
	 *  con un sleep de, justamente, un segundo
	 */
	public void generarElementoDeMapa() {
		Random rand = new Random();
		Objeto k;
		int r = rand.nextInt(4);
		Posicion p = miCamino.getPosAleatoria();
		switch (r) {
			case 0:
				k = new Roca(p);
				matriz[p.getX()][p.getY()].addObjeto(k);
				mapaVisual.agregarObjeto(k,p);
				break;
			case 1:
				k = new CampoDeDaño(p);
				matriz[p.getX()][p.getY()].addObjeto(k);
				mapaVisual.agregarObjeto(k, p);
				break;
			case 2:
				k = new Lago(p); //todos los objetos temporales tendrian asociados un contador Thread para contar el tiempo que tardan en irse
				matriz[p.getX()][p.getY()].addObjeto(k);
				mapaVisual.agregarObjeto(k, p);
				break;
			case 3:
				k = new CampoDebilitador(p);
				matriz[p.getX()][p.getY()].addObjeto(k);
				mapaVisual.agregarObjeto(k, p);
				break;
		}
	}
	
	public void eliminarControlable (Controlable C) {
		getCelda (C.getPos ().getX (), C.getPos ().getY ()).EliminarControlableDeCelda (C);
		unidadesEnMapa.remove (C);
	}
	
	public void eliminarEnemigo (Enemigo E) {
		if(E != null)
			System.out.println("Enemigo no nulo");
		if(E.getPos() == null)
			System.out.println("Posicion del enemigo a eliminar Nula");
		getCelda (E.getPos ().getX (), E.getPos ().getY ()).EliminarEnemigoDeCelda (E); //me tira NullPointer acá, por lo que parece, la posición del enemigo es nula, no el enemigo en si
		enemigosEnMapa.remove (E);
	}
	
	public void eliminarObjeto (Objeto O) {
		getCelda (O.getPos ().getX (), O.getPos ().getY ()).EliminarObjetoDeCelda (O);
		objetosEnMapa.remove (O);
	}
	
	public void restarVida () {
		P.restarVida ();
	}
	
	@SuppressWarnings("rawtypes")
	public void interaccionControlableEnemigo () {
		Collection<Enemigo> aSacarE = new LinkedList<Enemigo>(); //lista auxiliar para eliminar enemigos
		Collection<Controlable> aSacarC = new LinkedList<Controlable>(); //lista auxiliar para eliminar Controlables
		Iterator it = unidadesEnMapa.iterator ();
		Controlable c;
		Enemigo e;
		while (it.hasNext ()) {
			c = (Controlable) it.next ();
			e = c.verificarUnidad ();
			if (e != null && e.estoyEnJuego ()) {
				e.serAtacado (c);
				if(e.getEstado().getVida() <= 0) //pregunto si despues de ser atacado, el enemigo murió
					aSacarE.add(e);
				if(c.getEstado().getVida() <= 0) //pregunto si en caso de ser contratacado, el controlable murió
					aSacarC.add(c);
			}
		}
		for(Enemigo h: aSacarE){
			eliminarEnemigo(h);
			miNivel.murioEnemigo(h);
			//le digo al Nivel que murió un enemigo para que lo saque de su hilo correspondiente
			//h.morir(); me tira NullPointer cuando le va a decir al Hilo que lo saque, ver esto que parece que va entre un Deadlock y un NullPointer
		}
		for(Controlable C: aSacarC){
			unidadesEnMapa.remove(C);
			//avisarle al Nivel que se murió un Controlable
			C.morir();
		}
	}
	
	/**
	 * método que se encargará de eliminar todo lo que haya quedado en el nivel una vez que el mismo terminó (asumo que no hay más enemigos?)
	 */
	public void eliminarTodo(){
		Iterator<Controlable> it1 = unidadesEnMapa.iterator();
		Iterator<Objeto> it2 = objetosEnMapa.iterator();
		while(it1.hasNext()){
			Controlable C=it1.next();
			C.morir();
		}
		while(it2.hasNext()){
			Objeto O = it2.next();
			//eliminar objeto del juego
			objetosEnMapa.remove(O);
		}
	}
}