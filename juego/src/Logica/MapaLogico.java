package Logica;

import java.util.Collection;
import java.util.LinkedList;

import entidades.Controlable;
import entidades.Enemigo;

public class MapaLogico {
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
		miCamino = new Camino1 ();
		enemigos = new LinkedList<Enemigo>();
		unidadesEnMapa = new LinkedList<Controlable>();
	}
	
	public static MapaLogico InstanciaMapaLogico () {
		if (Instancia == null) {
			Instancia = new MapaLogico (500,320);
		}
		return Instancia;
	}
	
	public Celda getCelda (int X, int Y) {
		if (posicionValida(X,Y))
		return matriz [X/tamaño] [Y/tamaño];
		
		else return null;
	}
	
	public int getTamaño () {
		return tamaño;
	}
	
	public Camino getCamino () {
		return miCamino;
	}
	
	public void generarCaminoA (Posicion pos) {
		miCamino.generarCaminoA (pos);
	}
	
	public boolean puedoInsertarPersonaje (Posicion pos) {
		boolean puedo;
		if (!miCamino.perteneceAlCamino (pos) && matriz [pos.getX()/tamaño][pos.getY()/tamaño].getPersonaje () == null) {
			puedo = true;
		}
		else {
			puedo = false;
		}
		return puedo;
	}

	public Collection<Controlable> getListaControlables(){
		return unidadesEnMapa;
	}

	public Collection<Enemigo> getListaEnemigos(){
		return enemigos;
	}
	
	public void agregarControlable(Controlable c, Posicion pos) {
		
		if (!miCamino.perteneceAlCamino(pos) && this.getCelda(pos.getX(), pos.getY())!=null)
			unidadesEnMapa.add(c);
			
	}
	
	
	public void agregarEnemigo (Enemigo e) {
		Posicion pos= e.getPos();
		if (posicionValida(pos.getX(), pos.getY())) {
		 enemigos.add(e);
		matriz[pos.getX()/20][pos.getY()/20].getEnemigos().add(e);
		}
	}

	private boolean posicionValida(int X, int Y) {
		return X>=0 && X<=width && Y>=0 && Y<= height;
	}

}