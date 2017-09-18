package Logica;

import entidades.enemigo;
import GUI.GUI;
/**
 * 
import mapa.Celda;
import mapa.Mapa;
import personajes.Jugador;
import personajes.Malo;
 * 
 *
 */


public class Nivel {
	//Son las medidas del mapaVisual
	private static int width=500;
	private static int height=320;
	private static String direccion= "C:\\Users\\Franco Sacomani\\Desktop\\Tower Defense\\MapaRecortado.png";
	private enemigo malo;
	private MapaLogico mapaLog;
	private Posicion [] camino;
	//variable de control del arreglo camino
	int i =0;
	private GUI gui;
	public Nivel (GUI gui) {
		this.gui=gui;
		//mapaLog= new MapaLogico(gui.getMapaVisual().getWidth,gui.getMapaVisual().getHeight);
		// generarCamino()--> crea el arreglo Camino con las Posiciones Correspondientes
			
		//crearEnemigos();
		
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
	public String getRutaMapa() {
		return direccion;
	}
	public int anchoMapa() {
		return width;
	}
	public int largoMapa() {
		return height;
	}

}
