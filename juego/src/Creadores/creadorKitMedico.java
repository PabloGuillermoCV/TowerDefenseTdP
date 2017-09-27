package Creadores;

import Objetos.KitMedico;
import Logica.Celda;
import entidades.Controlable;

@SuppressWarnings("serial")
public class creadorKitMedico extends Factory {
	
	public creadorKitMedico () {
		super ("src\\GUI\\Sprites Botones\\KitMedico.png", "KitMedico", 220);
	}

	public Controlable crear (Celda C) {
		KitMedico KM = new KitMedico (C.getEsquinaIzq());
		C.addObjeto (KM);
		return null;
	}

}