package Objetos.ObjsDeLaTienda;

import entidades.Controlable;
import entidades.Enemigo;

public class KitMedico extends ObjDeLaTienda {
	
	public KitMedico () {
		super ("KitMedico", null, 200, 50);
	}
	
	public void Afectar (Controlable P) {
		//Recupera toda la vida
		P.getEstado ().setVida (P.getVidaMax ());
	}
	
	public void Afectar (Enemigo P) {}
}