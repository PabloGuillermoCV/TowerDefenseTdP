package Objetos.PowerUpsDelMapa;

import Logica.Posicion;
import entidades.Objeto;
import entidades.Personaje;

public abstract class PowerUpDelMapa extends Objeto {
	
	public PowerUpDelMapa (String Nombre, Posicion Pos) {
		super (Nombre,Pos);
	}
	
	public void Afectar () {}
	
	public abstract void Afectar (Personaje P);
}