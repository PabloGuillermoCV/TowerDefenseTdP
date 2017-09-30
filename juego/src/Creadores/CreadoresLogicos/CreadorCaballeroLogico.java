package Creadores.CreadoresLogicos;

import Controlables.Caballero;
import Logica.Celda;
import entidades.Controlable;

public class CreadorCaballeroLogico extends FactoryLogica {
	
	public Controlable crear (Celda C) {
		Caballero c = new Caballero (C.getEsquinaIzq());
		C.addPersonaje (c);
		return c;
	}
}