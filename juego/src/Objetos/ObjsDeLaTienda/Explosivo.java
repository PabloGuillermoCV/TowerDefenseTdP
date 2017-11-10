package Objetos.ObjsDeLaTienda;

import entidades.Controlable;
import entidades.Enemigo;

public class Explosivo extends ObjDeLaTienda {
	
	protected int Daño = 50;
	protected int Rango;
	
	public Explosivo () {
		super ("Explosivo", null, 200, 75);
		Rango = 4;
	}
	
	public void Afectar (Controlable C) {
		//Va a entrar a este metodo a traves de un recorrido similar al de controlable
		C.getEstado ().setVida (C.getEstado ().getVida () - Daño);
	}
	
	public void Afectar (Enemigo E) {
		//Va a entrar a este metodo a traves de un recorrido similar al de controlable
		E.getEstado ().setVida (E.getEstado ().getVida () - Daño);
	}
}