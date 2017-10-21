package entidades;

import Logica.Posicion;

public abstract class ObjetoResistente extends Objeto {
	
	protected int Vida;
	
	public ObjetoResistente (String Nombre, Posicion Pos, int Vida) {
		super (Nombre,Pos);
		this.Vida = Vida;
	}
	
	public int getVida () {
		return Vida;
	}
	
	public void serAtacado (Personaje P) {
		
	}
}