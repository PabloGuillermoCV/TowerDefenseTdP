package entidades;

import java.awt.Graphics;

import javax.swing.JLabel;

public abstract class Conceptual extends entidad {
	
	protected int Costo;
	
	public Conceptual (String nombre, Graphics label, JLabel getLabel, int Costo) {
		super (nombre,label,getLabel);
		this.Costo = Costo;
	}
	
	public int getCosto () {
		return Costo;
	}
}