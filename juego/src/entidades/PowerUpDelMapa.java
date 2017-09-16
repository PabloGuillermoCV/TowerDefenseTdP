package entidades;

import Mapa.Posicion;

public abstract class PowerUpDelMapa extends ObjDentroDelMapa {
	
	protected enemigo ContieneEnemigo;
	
	public PowerUpDelMapa (String Nombre, String Label, Posicion Pos, int Probabilidad,
			enemigo ContieneEnemigo) {
		super (Nombre,Label,Pos,Probabilidad);
		this.ContieneEnemigo = ContieneEnemigo;
	}
	
	public enemigo getEnem () {
		return ContieneEnemigo;
	}
}