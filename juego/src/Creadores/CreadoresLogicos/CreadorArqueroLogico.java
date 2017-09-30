package Creadores.CreadoresLogicos;

import Controlables.Arquero;
import entidades.Controlable;

public class CreadorArqueroLogico implements FactoryLogica {
	
	public Controlable crear () {
		Arquero A = new Arquero ();
		return A;
	}
}