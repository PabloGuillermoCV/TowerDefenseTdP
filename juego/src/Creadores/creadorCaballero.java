package Creadores;

import Controlables.Caballero;
import Logica.Celda;
import entidades.Controlable;

@SuppressWarnings("serial")
public class creadorCaballero extends Factory {
	
	public creadorCaballero () {
		super ("src\\GUI\\Sprites Botones\\Caballero.png", "Caballero", 500);
	}
	
	public Controlable crear (Celda C) {
		Caballero c = new Caballero (C.getEsquinaIzq());
		C.addPersonaje (c);
		return c;
	}
}