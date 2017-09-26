package Creadores;

import Objetos.KitMedico;
import Logica.Celda;
import entidades.Controlable;

public class creadorKitMedico extends Factory {

	public Controlable crear (Celda C) {
		KitMedico KM = new KitMedico (C.getEsquinaIzq());
		C.addObjeto (KM);
		return null;
	}

}