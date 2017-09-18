package entidades;

import Logica.Posicion;

public abstract class ObjetoResistente extends ObjDentroDelMapa {
	
	protected int Vida;
	
	public ObjetoResistente (String Nombre, String Label, Posicion Pos, int Probabilidad, int Vida) {
		super (Nombre,Label,Pos,Probabilidad);
		this.Vida = Vida;
	}
	
	public int getVida () {
		return Vida;
	}
	
	public void serAtacado (personaje P) {
		
	}
}