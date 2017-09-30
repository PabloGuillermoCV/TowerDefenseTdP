package Creadores.CreadoresLogicos;

import Controlables.Elite;
import entidades.Controlable;

public class CreadorEliteLogico implements FactoryLogica {
	
	public Controlable crear() {
		Elite E = new Elite ();
		return E;
	}
}
