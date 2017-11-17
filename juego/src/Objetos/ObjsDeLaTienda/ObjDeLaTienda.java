package Objetos.ObjsDeLaTienda;

import Logica.Posicion;
import entidades.Enemigo;
import entidades.Objeto;

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
	
	public void Afectar (Enemigo E) {}
	
	public Objeto Agarrar () {
		return null;
	}
}