package Objetos.ObjsDeLaTienda;

import entidades.Personaje;

public class Explosivo extends ObjDeLaTienda {
	
	protected int Daño = 50;
	protected int Rango;
	
	public Explosivo () {
		super ("Explosivo", null, 200, 75);
		Rango = 4;
	}
	
	public void Afectar () {}

	public void Atacar(Personaje personaje) {
		personaje.getEstado().setVida(personaje.getEstado().getVida() - Daño);
		
	}
}