package Objetos.ObjResistente;

import Logica.Posicion;
import entidades.Objeto;
import entidades.Personaje;

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