package entidades;

public abstract class Conceptual extends Entidad {
	
	protected int Costo;
	
	public Conceptual (String Nombre, String Label, int Costo) {
		super (Nombre,Label);
		this.Costo = Costo;
	}
	
	public int getCosto () {
		return Costo;
	}
}