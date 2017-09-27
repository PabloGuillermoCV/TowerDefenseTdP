package Creadores;

import Objetos.Armadura;
import Logica.Celda;
import entidades.Controlable;

@SuppressWarnings("serial")
public class creadorArmadura extends Factory {
	
	public creadorArmadura () {
		super ("src\\GUI\\Sprites Botones\\Armadura.png", "Armadura", 400);
	}

	public Controlable crear (Celda C) {
		Armadura A = new Armadura (C.getEsquinaIzq());
		C.addObjeto (A);
		return null;
	}
}