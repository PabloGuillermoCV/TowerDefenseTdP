package entidades;

import javax.swing.JLabel;
import Mapa.Posicion;

/**
 * Clase que mantiene la posicion XY de una entidad cualquiera en el Mapa
 * @author Pablo Guillermo Ceballos Vitale
 *
 */
public abstract class fisico extends entidad {

	protected Posicion Pos;
	
	public fisico (String Nombre, JLabel Label, Posicion Pos) {
		super (Nombre,Label);
		this.Pos = Pos;
	}
	
	public Posicion getPos () {
		return Pos;
	}
}