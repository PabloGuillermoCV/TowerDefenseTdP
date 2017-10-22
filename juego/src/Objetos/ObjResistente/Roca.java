package Objetos.ObjResistente;

import Logica.Posicion;
import entidades.ObjetoResistente;

public class Roca extends ObjetoResistente {

	public Roca (String Nombre, Posicion Pos, int Vida) {
		super (Nombre, Pos, Vida);
	}

	public void setVida (int i) {
		Vida = i;
	}
	
	public void Afectar () {}
}