package Creadores.CreadoresLogicos;

import Objetos.Armadura;
import Logica.Celda;
import entidades.Controlable;

public class CreadorArmaduraLogica extends FactoryLogica {

	public Controlable crear (Celda C) {
		Armadura A = new Armadura (C.getEsquinaIzq());
		C.addObjeto (A);
		return null;
	}
}