package Objetos.PowerUpsDelMapa;

import Logica.Posicion;
import entidades.Enemigo;
import entidades.Objeto;

public abstract class PowerUpDelMapa extends Objeto {
	
	protected Enemigo ContieneEnemigo;
	
	public PowerUpDelMapa (String Nombre, Posicion Pos, Enemigo ContieneEnemigo) {
		super (Nombre,Pos);
		this.ContieneEnemigo = ContieneEnemigo;
	}
	
	public Enemigo getEnem () {
		return ContieneEnemigo;
	}
}