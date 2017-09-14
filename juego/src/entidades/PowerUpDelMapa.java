package entidades;

import javax.swing.JLabel;
import Mapa.Posicion;

public abstract class PowerUpDelMapa extends ObjDentroDelMapa {
	
	protected enemigo ContieneEnemigo;
	
	public PowerUpDelMapa (String Nombre, JLabel Label, Posicion Pos, int Probabilidad,
			enemigo ContieneEnemigo) {
		super (Nombre,Label,Pos,Probabilidad);
		this.ContieneEnemigo = ContieneEnemigo;
	}
	
	public enemigo getEnem () {
		return ContieneEnemigo;
	}
}