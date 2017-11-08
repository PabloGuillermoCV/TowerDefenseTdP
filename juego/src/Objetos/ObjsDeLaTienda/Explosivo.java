package Objetos.ObjsDeLaTienda;

import entidades.Controlable;
import entidades.Personaje;

public class Explosivo extends ObjDeLaTienda {
	
	protected int Daño = 50;
	protected int Rango;
	
	public Explosivo () {
		super ("Explosivo", null, 200, 75);
		Rango = 4;
	}
	
	public void Afectar (Personaje P) {
		//Va a entrar a este metodo a traves de un recorrido similar al de controlable
		P.getEstado ().setVida (P.getEstado ().getVida () - Daño);
	}
	
	public void Afectar (Controlable C) {}
}