package entidades;

import Logica.Posicion;

public abstract class ObjetoTemporal extends ObjDentroDelMapa {
	
	protected int Tiempo;
	
	public ObjetoTemporal (String Nombre, String Label, Posicion Pos, int Probabilidad, int Tiempo) {
		super (Nombre,Label,Pos,Probabilidad);
		this.Tiempo = Tiempo;
	}
	
	public int getTiempo () {
		return Tiempo;
	}
}