package entidades;

import Logica.Posicion;

public abstract class ObjDeLaTienda extends Objeto {
	
	protected int Costo;
	protected int CuantoAfecto;
	
	public ObjDeLaTienda (String Nombre, Posicion Pos, int Costo, int CuantoAfecto) {
		super (Nombre, Pos);
		this.Costo = Costo;
		this.CuantoAfecto = CuantoAfecto;
	}
	
	public int getCosto () {
		return Costo;
	}
}