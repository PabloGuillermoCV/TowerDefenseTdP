package Creadores;

import Controlables.Soldado;
import Logica.Celda;
import entidades.Controlable;

@SuppressWarnings("serial")
public class creadorSoldado extends Factory {
	
	public creadorSoldado () {
		super ("src\\GUI\\Sprites Botones\\Soldado.png", "Soldado", 200);
	}

	public Controlable crear (Celda C) {
		Soldado S = new Soldado (C.getEsquinaIzq());
		C.addPersonaje (S);
		return S;
	}

}