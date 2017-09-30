package Creadores.CreadoresLogicos;

import Objetos.Armadura;
import entidades.Controlable;

public class CreadorArmaduraLogica implements FactoryLogica {

	@SuppressWarnings("unused")
	public Controlable crear () {
		Armadura A = new Armadura ();
		return null;
	}
}