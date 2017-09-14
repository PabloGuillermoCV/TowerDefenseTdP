package entidades;

import javax.swing.JLabel;
import Mapa.Posicion;

public abstract class ObjDentroDelMapa extends fisico {
	
	protected int Probabilidad;
	
	public ObjDentroDelMapa (String Nombre, JLabel Label, Posicion Pos, int Probabilidad) {
		super (Nombre,Label,Pos);
		this.Probabilidad = Probabilidad;
	}
	
	public int getProb(){
		return Probabilidad;
	}
}