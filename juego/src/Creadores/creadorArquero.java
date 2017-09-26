package Creadores;

import Controlables.Arquero;
import Logica.Celda;
import entidades.Controlable;

public class creadorArquero extends Factory{

	public Controlable crear (Celda C) {
		Arquero A = new Arquero (C.getEsquinaIzq());
		C.addPersonaje (A);
		return A;
	}
}