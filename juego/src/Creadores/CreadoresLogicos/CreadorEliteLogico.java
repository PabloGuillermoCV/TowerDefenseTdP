package Creadores.CreadoresLogicos;

import Controlables.Elite;
import Logica.Celda;
import entidades.Controlable;

public class CreadorEliteLogico extends FactoryLogica {
	
	public Controlable crear(Celda C) {
		Elite E = new Elite(C.getEsquinaIzq());
		C.addPersonaje (E);
		return E;
	}
}
