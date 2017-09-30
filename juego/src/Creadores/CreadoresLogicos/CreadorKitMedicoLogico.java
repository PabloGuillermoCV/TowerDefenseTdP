package Creadores.CreadoresLogicos;

import Objetos.KitMedico;
import Logica.Celda;
import entidades.Controlable;

public class CreadorKitMedicoLogico extends FactoryLogica {

	public Controlable crear (Celda C) {
		KitMedico KM = new KitMedico (C.getEsquinaIzq());
		C.addObjeto (KM);
		return null;
	}
}