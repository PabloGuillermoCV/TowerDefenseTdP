package Mapa;

public class Posicion {
	
	@SuppressWarnings("unused")
	private int X;
	@SuppressWarnings("unused")
	private int Y;
	
	/**
	 * Constructor de la Posicion xy
	 * @param x coordenada X
	 * @param y coordenada Y
	 */
	public Posicion(int x, int y){
		X = x;
		Y = y;
	}
	
	//comandos
	/**
	 * modifica la posicion X
	 * @param x nueva posicion x
	 */
	public void setX(int x){
		X = x;
	}
	/**
	 * modifica la posicion Y
	 * @param y nueva posicion y
	 */
	public void setY(int y){
		Y = y;
	}
	
}
