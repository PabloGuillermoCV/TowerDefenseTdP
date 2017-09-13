package entidades;

import java.awt.Graphics;

import javax.swing.JLabel;

import Mapa.Posicion;

public abstract class PowerUpDelMapa extends ObjDentroDelMapa {
	
	protected enemigo ContieneEnemigo;
	
	public PowerUpDelMapa (String nombre, Graphics label, JLabel getLabel, Posicion Pos, int Width,
			int Height, int Probabilidad, enemigo ContieneEnemigo) {
		super (nombre,label,getLabel,Pos,Width,Height,Probabilidad);
		this.ContieneEnemigo = ContieneEnemigo;
	}
	
	public enemigo getEnem () {
		return ContieneEnemigo;
	}
}