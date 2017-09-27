package Creadores;

import Controlables.Elite;
import Logica.Celda;
import entidades.Controlable;

@SuppressWarnings("serial")
public class creadorElite extends Factory {
	
	public creadorElite () {
		super ("src\\GUI\\Sprites Botones\\Elite.png", "Elite", 650);
	}
	
	public Controlable crear(Celda C) {
		Elite E = new Elite(C.getEsquinaIzq());
		C.addPersonaje (E);
		return E;
	}

}
