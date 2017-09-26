package Creadores;

import Controlables.Caballero;
import Logica.Celda;
import entidades.Controlable;

public class creadorCaballero extends Factory {

	
	public Controlable crear(Celda C) {
		Caballero c = new Caballero(C.getEsquinaIzq());
		C.addP(c);
		return c;
	}

}
