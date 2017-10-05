package Logica;

public class Posicion {
	
	private int X;
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
	
	//Comandos
	/**
	 * Retorna el atributo X
	 * @return Un entero X
	 */
	public int getX () {
		return X;
	}
	
	/**
	 * Retorna el atributo Y
	 * @return Un entero Y
	 */
	public int getY () {
		return Y;
	}
	
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
	public String toString () {
		String resp=""+ X+ " "+Y;
		
		return resp;
	}
}