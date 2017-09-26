package Creadores;

import Objetos.Armadura;
import Logica.Celda;
import entidades.Controlable;

public class creadorArmadura extends Factory {

	public Controlable crear (Celda C) {
		Armadura A = new Armadura (C.getEsquinaIzq());
		C.addObjeto (A);
		return null;
	}

}