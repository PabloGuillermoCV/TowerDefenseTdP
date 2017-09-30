package Creadores.CreadoresLogicos;

import Objetos.KitMedico;
import entidades.Controlable;

public class CreadorKitMedicoLogico implements FactoryLogica {

	@SuppressWarnings("unused")
	public Controlable crear () {
		KitMedico KM = new KitMedico ();
		return null;
	}
}