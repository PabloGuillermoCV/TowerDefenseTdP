package entidades;

import Mapa.Posicion;

public abstract class ObjDentroDelMapa extends fisico {
	
	protected int Probabilidad;
	
	public ObjDentroDelMapa (String Nombre, String Label, Posicion Pos, int Probabilidad) {
		super (Nombre,Label,Pos);
		this.Probabilidad = Probabilidad;
	}
	
	public int getProb(){
		return Probabilidad;
	}
}