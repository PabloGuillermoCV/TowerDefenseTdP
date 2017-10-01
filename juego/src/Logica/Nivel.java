package Logica;

import java.util.LinkedList;
import Enemigos.*;
import GUI.GUI;
import entidades.*;

public class Nivel {
	//Son las medidas del mapaVisual
	private static int widthM = 500;
	private static int heightM = 320;
	//Son las medidas de tiendaVisual
	private static int widthS = 200;
	private static int heightS = 120;
	@SuppressWarnings("unused")
	private Enemigo malo;
	private MapaLogico mapaLog;
	@SuppressWarnings("unused")
	private TiendaLogica tiendaLog;
	private Posicion [] camino;
	private VisitorConcreto Ataques;
	private GUI gui;
	
	public Nivel (GUI gui) {
		this.gui = gui;
		mapaLog = new MapaLogico (widthM,heightM);
		tiendaLog = new TiendaLogica ();
		generarCamino ();
		crearEnemigos ();
	}
	
	/**
	 * el metodo crearEnemigos(), carga la lista de enemigos con los enemigos concretos,(este metodo
	 * podria recibir una abstracFactory que cree a todos los enemigos). En el constructor de cada enem
	 * le mandamos la primer posicion de arreglo camino que es de donde partiran, y por ultimos haremos
	 * gui.add (etiqueta Grafica) asi lo hacemos aparecer
	 */
	/**
	private void crearEnemigos() {
		//deberiamos recorrer la lista y crear cada enemigo concreto
		malo= new enemigo(camino[i]);
		
		gui.add(malo.getLabel());
		
			
	}
	**/
	
	/**
	 * para cada enemigos de la lista , haremos malo.moverA(y le enviamos la Posicion a donde queremos
	 * que vaya) esa Posicion sera la Posicion del arreglo camino marcada por la variable de control i
	 * Luego de recorrer toda la lista y mover, aumentamos en uno la variable de control. Habria que
	 * pensar que hacer cuando llegamos al final de camino
	 */
	/**
	public void mover() {
		//deberiamos recorrer la lista
		malo.moverA(camino[i]);
		
		i++;
	}
	**/
	
	public int anchoMapa () {
		return widthM;
	}
	
	public int largoMapa () {
		return heightM;
	}
	
	public int anchoTienda () {
		return widthS;
	}
	
	public int largoTienda () {
		return heightS;
	}
	
	public MapaLogico getMapaLog () {
		return mapaLog;
	}
	
	public Posicion [] getCamino () {
		return camino;
	}
	
	public GUI getGui () {
		return gui;
	}
	
	private void generarCamino () {
		camino = new Posicion [37];
		int I = 0;
		int X = 0;
		int Y = 0;
		while (I < 37) {
			if (X < 460) {
				camino [I] = new Posicion (X,Y);
				X += 20;
			}
			else {
				camino [I] = new Posicion (X,Y);
				Y += 20;
			}
			I++;
		}
	}
	
	public void mover () {
		Celda c;
		LinkedList <Enemigo> Aux;
		LinkedList <Enemigo> Movidos = new LinkedList <Enemigo> ();
		for (int I = 0; I < camino.length; I++) {
			c = mapaLog.getCelda(camino [I].getX (), camino [I].getY ());
			Aux = c.getEnemigos ();
			if (!Aux.isEmpty ()) {
				Enemigo Actual = Aux.getFirst (); 
				if(!fueMovido(Aux.getFirst(), Movidos)){
					Movidos.addLast(Actual);
					Actual.MoverA(camino [I+1]);
					mapaLog.getCelda(camino[I+1].getX(), camino[I+1].getY()).addEnemigo(c.getEnemigos().removeFirst());
					Movidos.removeLast();
				}
			}
		}
	}
	
	private boolean fueMovido (Enemigo E, LinkedList <Enemigo> Movidos) {
		return Movidos.contains(E);
	}
	
	private void crearEnemigos () {
		APie E = new APie (camino [0]);
		Celda c = mapaLog.getCelda(camino [0].getX (),camino [0].getY ());
		c.getEnemigos().addLast(E);
		gui.getMapaVisual().getFondo().add(E.getGrafico());
	}
}