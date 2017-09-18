package entidades;

import Logica.Posicion;

/**
 * Clase que mantiene la posicion XY de una entidad cualquiera en el Mapa
 * @author Pablo Guillermo Ceballos Vitale
 *
 */
public abstract class fisico extends entidad {

	protected Posicion pos;
	
	public fisico (String Nombre, String Label, Posicion Pos) {
		super (Nombre,Label);
		this.pos = Pos;
	}
	
	public Posicion getPos () {
		return pos;
	}
	
	public void setPos (Posicion P) {
		this.pos = P;
	}
}