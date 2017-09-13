package entidades;

import java.awt.Graphics;

import javax.swing.JLabel;

import Mapa.Posicion;

public abstract class ObjetoTemporal extends ObjDentroDelMapa {
	
	protected int Tiempo;
	
	public ObjetoTemporal (String nombre, Graphics label, JLabel getLabel, Posicion Pos, int Width,
			int Height, int Probabilidad, int Tiempo) {
		super (nombre,label,getLabel,Pos,Width,Height,Probabilidad);
		this.Tiempo = Tiempo;
	}
	
	public int getTiempo () {
		return 0;
	}
}