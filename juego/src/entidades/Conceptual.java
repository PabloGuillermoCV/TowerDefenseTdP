package entidades;

public abstract class Conceptual extends entidad {
	
	protected int Costo;
	
	public Conceptual (String Nombre, String Label, int Costo) {
		super (Nombre,Label);
		this.Costo = Costo;
	}
	
	public int getCosto () {
		return Costo;
	}
}