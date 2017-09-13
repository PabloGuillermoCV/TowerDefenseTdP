package entidades;

import java.awt.Graphics;

import javax.swing.JLabel;

import Mapa.Posicion;

public abstract class ObjetoResistente extends ObjDentroDelMapa {
	
	protected int Vida;
	
	public ObjetoResistente (String nombre, Graphics label, JLabel getLabel, Posicion Pos, int Width,
			int Height, int Probabilidad, int Vida) {
		super (nombre,label,getLabel,Pos,Width,Height,Probabilidad);
		this.Vida = Vida;
	}
	
	public int getVida () {
		return 0;
	}
}