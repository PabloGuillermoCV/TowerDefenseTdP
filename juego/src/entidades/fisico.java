package entidades;

import java.awt.Graphics;

import javax.swing.JLabel;

import Mapa.Posicion;

/**
 * Clase que mantiene la posicion XY de una entidad cualquiera en el Mapa
 * @author Pablo Guillermo Ceballos Vitale
 *
 */
public abstract class fisico extends entidad {

	protected Posicion Pos;
	protected int Width;
	protected int Height;
	
	public fisico (String nombre, Graphics label, JLabel getLabel, Posicion Pos, int Width, int Height) {
		super (nombre,label,getLabel);
		this.Pos = Pos;
		this.Width = Width;
		this.Height = Height;
	}
	
	public Posicion getPos () {
		return Pos;
	}
	
	public int getWidth () {
		return Width;
	}
	
	public int getHeight () {
		return Height;
	}
}