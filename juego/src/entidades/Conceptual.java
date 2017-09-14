package entidades;

import javax.swing.JLabel;

public abstract class Conceptual extends entidad {
	
	protected int Costo;
	
	public Conceptual (String Nombre, JLabel Label, int Costo) {
		super (Nombre,Label);
		this.Costo = Costo;
	}
	
	public int getCosto () {
		return Costo;
	}
}