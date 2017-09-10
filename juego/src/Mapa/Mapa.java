package Mapa;
import java.awt.Graphics;
import java.util.Collection;

public class Mapa {
	
	private Collection<Posicion> camEnemigo; //camino por donde pasan los enemigos
	private int maxX;
	private int maxY;
	private Graphics fondo;
	private Posicion[][] grilla1; //calculo que a esto se referian el Ayudante y marcos con lo de la grilla
	
	public Mapa(String dir, int X, int Y){
		maxX = X;
		maxY = Y;
		grilla1 = new Posicion[X][Y];
		//fondo = imagen en dir?
	}
	
	/**
	 * dibuja el mapa 
	 * @param G (no tengo idea que hace, lo dejo en manos de Franco)
	 */
	public void Paint(Graphics G){
	
	}
	/**
	 * devuelve el camino por donde pasan los enemigos
	 * @return camino de los enemigos en Posiciones del Mapa
	 */
	public Collection<Posicion> getPath(){
		return camEnemigo;
	}
	/**
	 * devuielve la frontera máxima de X del mapa
	 * @return punto máximo de X
	 */
	public int getMaxX(){
		return maxX;
	}
	
	/**
	 * devuielve la frontera máxima de Y del mapa
	 * @return punto máximo de Y
	 */
	public int getMaxY(){
		return maxY;
	}
	
	/**
	 * devuelve la imagen de fondo
	 * @return el fondo del nivel
	 */
	public Graphics getFondo(){
		return fondo;
	}
	
	
}
