package Objetos.ObjsDeLaTienda;

import entidades.ObjDeLaTienda;

public class Explosivo extends ObjDeLaTienda {
	
	protected int Rango;
	
	public Explosivo () {
		super ("Explosivo", null, 200, 75);
		Rango = 4;
	}
	
	public void Afectar () {}
}