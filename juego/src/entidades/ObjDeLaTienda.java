package entidades;

import Logica.Posicion;

public abstract class ObjDeLaTienda extends Objeto {
	
	protected int Precio;
	protected int CuantoAfecto;
	
	public ObjDeLaTienda (String Nombre, Posicion Pos, int Precio, int CuantoAfecto) {
		super (Nombre, Pos);
		this.Precio = Precio;
		this.CuantoAfecto = CuantoAfecto;
	}
	
	public int getPrecio () {
		return Precio;
	}
}