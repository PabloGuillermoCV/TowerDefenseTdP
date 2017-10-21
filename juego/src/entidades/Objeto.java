package entidades;

import Logica.Posicion;

public abstract class Objeto extends Entidad {
	
	public Objeto (String Nombre, Posicion Pos) {
		super (Nombre, Pos);
	}
	
	public abstract void Afectar ();
}