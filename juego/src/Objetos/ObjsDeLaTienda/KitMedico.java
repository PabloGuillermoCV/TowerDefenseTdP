package Objetos.ObjsDeLaTienda;

import entidades.Controlable;
import entidades.Personaje;

public class KitMedico extends ObjDeLaTienda {
	
	public KitMedico () {
		super ("KitMedico", null, 200, 50);
	}
	
	public void Afectar (Personaje P) {}
	
	public void Afectar (Controlable P) {
		//Recupera toda la vida
		P.getEstado ().setVida (P.getVidaMax ());
	}
}