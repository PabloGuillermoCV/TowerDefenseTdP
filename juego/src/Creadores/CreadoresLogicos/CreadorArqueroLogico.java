package Creadores.CreadoresLogicos;

import Controlables.Arquero;
import Logica.Celda;
import entidades.Controlable;

public class CreadorArqueroLogico extends FactoryLogica {
	
	public Controlable crear (Celda C) {
		Arquero A = new Arquero (C.getEsquinaIzq());
		C.addPersonaje (A);
		return A;
	}
}