package Creadores;

import Logica.Celda;
import entidades.Controlable;

@SuppressWarnings("serial")
public class creadorCatapulta extends Factory {
	
	public creadorCatapulta () {
		super ("src\\GUI\\Sprites Botones\\Catapulta.png", "Catapulta", 500);
	}
	
	public Controlable crear(Celda C) {
		// TODO Auto-generated method stub
		//ver que hacer acá porque la catapulta ocupa 2 espacios
		return null;
	}

}
