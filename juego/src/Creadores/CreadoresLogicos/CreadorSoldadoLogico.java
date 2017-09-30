package Creadores.CreadoresLogicos;

import Controlables.Soldado;
import entidades.Controlable;

public class CreadorSoldadoLogico implements FactoryLogica {

	public Controlable crear () {
		Soldado S = new Soldado ();
		return S;
	}
}