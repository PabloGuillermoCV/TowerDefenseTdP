package Creadores.CreadoresLogicos;

import Objetos.Explosivo;
import entidades.Controlable;

public class CreadorExplosivoLogico implements FactoryLogica {

	@SuppressWarnings("unused")
	public Controlable crear () {
		Explosivo E = new Explosivo ();
		return null;
	}
}