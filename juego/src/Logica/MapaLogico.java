package Logica;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Random;

import GUI.MapaVisual;
import Objetos.ObjResistente.CampoDeDaño;
import Objetos.ObjResistente.Roca;
import Objetos.ObjTemporal.CampoDebilitador;
import Objetos.ObjTemporal.Lago;
import entidades.Controlable;
import entidades.Enemigo;
import entidades.Objeto;

public class MapaLogico {
	private MapaVisual mapaVisual;
	protected Collection<Controlable> unidadesEnMapa;
	protected Collection <Enemigo> enemigos;
	private static MapaLogico Instancia;
	private Celda [][] matriz;
	private static int tamaño = 20;
	private static int width=500;
	private static int height =320;
	private Camino miCamino;
	
	/**
	 * constructor : inicializa la matriz de Celdas con un total de (el Ancho del Mapa)/20 por
	 * (alto del Mapa)/20. Usamos 20*20 por el tamaño del Sprite. Luego de inicializar la Matriz
	 * creamos cada Celda perteneciente a la matriz y le enviamos la posicion de su esquina izq.
	 */
	
	private MapaLogico (int w, int h) {
		matriz = new Celda [w/tamaño][h/tamaño];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz [0].length; j++) {
				matriz [i][j] = new Celda (i*tamaño,j*tamaño);
			}
		}
		miCamino = new Camino1Aux ();
		enemigos = new LinkedList<Enemigo>();
		unidadesEnMapa = new LinkedList<Controlable>();
	}
	
	public static MapaLogico InstanciaMapaLogico () {
		if (Instancia == null) {
			Instancia = new MapaLogico (500,320);
		}
		return Instancia;
	}
	
	public void setMapaVisual (MapaVisual MV) {
		this.mapaVisual = MV;
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
	
	public void generarCaminoA (Posicion pos) {
		miCamino.generarCaminoA ();
	}

	public Collection<Controlable> getListaControlables(){
		return unidadesEnMapa;
	}

	public Collection<Enemigo> getListaEnemigos(){
		return enemigos;
	}
	
	public boolean puedoAgregarControlable (Posicion pos) {
		boolean Puedo;
		//System.out.println("1 "+posicionValida (pos.getX(), pos.getY())); 
		//System.out.println("2 "+ !miCamino.perteneceAlCamino(pos));
		//System.out.println("3 "+matriz[pos.getX()/20][pos.getY()/20].getPersonaje() == null);
		
		if (posicionValida (pos.getX(), pos.getY()) && !miCamino.perteneceAlCamino(pos) && 
				matriz[pos.getX()/20][pos.getY()/20].getPersonaje() == null) {
			Puedo = true;
		}
		else {
			Puedo = false;
		}
		return Puedo;
	}
	
	public boolean puedoAgregarObjeto (Posicion pos) {
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
		
		//System.out.println("!! 1"+pos.getX()/20);
		//System.out.println("!! 2"+pos.getY()/20);
		matriz [pos.getX()/20][pos.getY()/20].addPersonaje (c);
		unidadesEnMapa.add (c);	
	}
	
	public void agregarEnemigo (Enemigo e) {
		Posicion pos= e.getPos();
		if (posicionValida(pos.getX(), pos.getY())) {
			enemigos.add(e);
			matriz[pos.getX()/20][pos.getY()/20].getEnemigos().add(e);
		}
	}

	private boolean posicionValida(int X, int Y) {
		return X >= 0 && X <= width && Y >= 0 && Y <= height;
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
		switch(r){
			
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
	
	public void eliminarEnemigo(Enemigo e) {
		getCelda(e.getPos().getX(),e.getPos().getY()).EliminarEnemigo(e);
		enemigos.remove(e);
		
	}
	
	public void eliminarControlable(Controlable c) {
		getCelda(c.getPos().getX(),c.getPos().getY()).eliminarControlable(c);
		unidadesEnMapa.remove(c);
	}
}