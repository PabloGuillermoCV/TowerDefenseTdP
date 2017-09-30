package Creadores.CreadoresLogicos;

import Controlables.Caballero;
import entidades.Controlable;

public class CreadorCaballeroLogico implements FactoryLogica {
	
	public Controlable crear () {
		Caballero c = new Caballero ();
		return c;
	}
}