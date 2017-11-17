package Objetos.ObjsDeLaTienda;

import entidades.Controlable;

public class SuperAlcance extends ObjDeLaTienda {
	
	public SuperAlcance () {
		super ("Super Alcance", null, 200, 75);
	}
	
	public void Afectar (Controlable C) {
		C.aumentarAlcance ();
	}
}