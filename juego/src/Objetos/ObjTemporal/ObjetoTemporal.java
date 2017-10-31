package Objetos.ObjTemporal;

import Logica.Posicion;
import entidades.Objeto;

public abstract class ObjetoTemporal extends Objeto {
	
	protected int Tiempo;
	
	public ObjetoTemporal (String Nombre, Posicion Pos, int Tiempo) {
		super (Nombre,Pos);
		this.Tiempo = Tiempo;
	}
	
	public int getTiempo () {
		return Tiempo;
	}
}