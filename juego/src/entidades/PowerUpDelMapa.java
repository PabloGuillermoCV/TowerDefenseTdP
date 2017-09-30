package entidades;

import Logica.Posicion;

public abstract class PowerUpDelMapa extends ObjDentroDelMapa {
	
	protected Enemigo ContieneEnemigo;
	
	public PowerUpDelMapa (String Nombre, String Label, Posicion Pos, int Probabilidad,
			Enemigo ContieneEnemigo) {
		super (Nombre,Label,Pos,Probabilidad);
		this.ContieneEnemigo = ContieneEnemigo;
	}
	
	public Enemigo getEnem () {
		return ContieneEnemigo;
	}
}