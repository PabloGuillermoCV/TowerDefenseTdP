package Creadores.CreadoresLogicos;

import Controlables.Catapulta;
import entidades.Controlable;

public class CreadorCatapultaLogica implements FactoryLogica {
	
	public Controlable crear() {
		Catapulta C = new Catapulta ();
		return C;
	}
}