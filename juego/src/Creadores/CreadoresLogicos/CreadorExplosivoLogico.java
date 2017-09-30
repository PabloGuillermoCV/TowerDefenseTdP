package Creadores.CreadoresLogicos;

import Objetos.Explosivo;
import Logica.Celda;
import entidades.Controlable;

public class CreadorExplosivoLogico extends FactoryLogica {

	public Controlable crear (Celda C) {
		Explosivo E = new Explosivo (C.getEsquinaIzq());
		C.addObjeto (E);
		return null;
	}
}