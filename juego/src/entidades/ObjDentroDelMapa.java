package entidades;

import Logica.Posicion;

public abstract class ObjDentroDelMapa extends Entidad {
	
	protected int Probabilidad;
	
	public ObjDentroDelMapa (String Nombre, String Label, Posicion Pos, int Probabilidad) {
		super (Nombre,Label,Pos);
		this.Probabilidad = Probabilidad;
	}
	
	public int getProb(){
		return Probabilidad;
	}
}