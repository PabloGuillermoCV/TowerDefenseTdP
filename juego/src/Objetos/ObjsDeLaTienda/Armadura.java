package Objetos.ObjsDeLaTienda;

import entidades.Controlable;

public class Armadura extends ObjDeLaTienda {
	
	public Armadura () {
		super ("Armadura", null, 200, 25);
	}
	
	public void Afectar (Controlable C) {
		ActivarInvincibilidad (C);
	}
	
	public void ActivarInvincibilidad (Controlable C) {
		C.setInvulnerable ();
	}
}