package entidades;

import Logica.Posicion;

public abstract class Conceptual extends Entidad {
	
	protected int Costo;
	
	public Conceptual (String Nombre, String Label, Posicion Pos, int Costo) {
		super (Nombre,Label,Pos);
		this.Costo = Costo;
	}
	
	public int getCosto () {
		return Costo;
	}
}