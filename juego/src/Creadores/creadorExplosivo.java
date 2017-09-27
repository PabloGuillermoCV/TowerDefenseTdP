package Creadores;

import Objetos.Explosivo;
import Logica.Celda;
import entidades.Controlable;

@SuppressWarnings("serial")
public class creadorExplosivo extends Factory {
	
	public creadorExplosivo () {
		super ("src\\GUI\\Sprites Botones\\Elite.png", "Explosivo", 450);
	}

	public Controlable crear (Celda C) {
		Explosivo E = new Explosivo (C.getEsquinaIzq());
		C.addObjeto (E);
		return null;
	}

}