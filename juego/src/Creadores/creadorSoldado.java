package Creadores;

import Controlables.Soldado;
import Logica.Celda;
import entidades.Controlable;

public class creadorSoldado extends Factory {

	public Controlable crear (Celda C) {
		Soldado S = new Soldado (C.getEsquinaIzq());
		C.addPersonaje (S);
		return S;
	}

}