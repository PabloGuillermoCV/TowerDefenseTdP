package entidades;

import Logica.Posicion;

/**
 * Clase que mantiene la posicion XY de una entidad cualquiera en el Mapa
 * @author Pablo Guillermo Ceballos Vitale
 *
 */
public abstract class Fisico extends Entidad {

	//protected Posicion pos;
	
	public Fisico (String Nombre, String Label, Posicion Pos) {
		super (Nombre,Label,Pos);
		//this.pos = Pos;
	}
	
	//QUE HACEN ESTOS METODOS??! DECIDAN PA QUE ESTAN O SI SIREVEN PORQUE A LAS PROXIMA LOS VUELO
	/*public Posicion getPos () {
		return pos;
	}
	
	public void setPos (Posicion P) {
		this.pos = P;
	}*/
}