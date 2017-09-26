package Creadores;

import Controlables.Elite;
import Logica.Celda;
import entidades.Controlable;

public class creadorElite extends Factory {

	
	public Controlable crear(Celda C) {
		Elite E = new Elite(C.getEsquinaIzq());
		C.addP(E);
		return E;
	}

}
