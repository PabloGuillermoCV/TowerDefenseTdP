package Objetos.ObjsDeLaTienda;

import entidades.Controlable;

public class KitMedico extends ObjDeLaTienda {
	
	public KitMedico () {
		super ("KitMedico", null, 200, 50);
	}
	
	public void Afectar (Controlable C) {
		//Recupera toda la vida
		C.getEstado ().setVida (C.getVidaMax ());
	}
}