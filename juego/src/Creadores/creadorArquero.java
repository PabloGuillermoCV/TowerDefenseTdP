package Creadores;

import Controlables.Arquero;
import Logica.Celda;
import entidades.Controlable;

@SuppressWarnings("serial")
public class creadorArquero extends Factory {
	
	public creadorArquero () {
		super ("src\\GUI\\Sprites Botones\\Arquero.png", "Arquero", 300);
	}

	public Controlable crear (Celda C) {
		Arquero A = new Arquero (C.getEsquinaIzq());
		C.addPersonaje (A);
		return A;
	}
}