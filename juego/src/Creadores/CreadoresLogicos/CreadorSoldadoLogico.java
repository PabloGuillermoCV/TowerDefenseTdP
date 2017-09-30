package Creadores.CreadoresLogicos;

import Controlables.Soldado;
import Logica.Celda;
import entidades.Controlable;

public class CreadorSoldadoLogico extends FactoryLogica {

	public Controlable crear (Celda C) {
		Soldado S = new Soldado (C.getEsquinaIzq());
		C.addPersonaje (S);
		return S;
	}
}