package Creadores;

import Objetos.Explosivo;
import Logica.Celda;
import entidades.Controlable;

public class creadorExplosivo extends Factory {

	public Controlable crear (Celda C) {
		Explosivo E = new Explosivo (C.getEsquinaIzq());
		C.addObjeto (E);
		return null;
	}

}