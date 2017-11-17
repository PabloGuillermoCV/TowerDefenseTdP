package Objetos.ObjResistente;

import Logica.Posicion;
import entidades.Controlable;
import entidades.Objeto;

public abstract class ObjetoResistente extends Objeto {
	
	protected int Vida;
	
	public ObjetoResistente (String Nombre, Posicion Pos, int Vida) {
		super (Nombre,Pos);
		this.Vida = Vida;
	}
	
	public int getVida () {
		return Vida;
	}
	
	public void setVida (int I) {
		Vida = I;
	}
	
	public void Afectar (Controlable C) {}
	
	public Objeto Agarrar () {
		return null;
	}
}