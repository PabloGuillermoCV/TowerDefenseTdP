package Objetos.PowerUpsDelMapa;

import Logica.Posicion;
import entidades.Controlable;
import entidades.Enemigo;
import entidades.Objeto;

public abstract class PowerUpDelMapa extends Objeto {
	
	public PowerUpDelMapa (String Nombre, Posicion Pos) {
		super (Nombre,Pos);
	}
	
	public void Afectar (Controlable C) {}
	
	public void Afectar (Enemigo E) {}
}