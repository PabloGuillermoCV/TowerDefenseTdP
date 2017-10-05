package Objetos;

import Logica.Posicion;
import entidades.ObjetoResistente;


public class Roca extends ObjetoResistente {

	public Roca(String Nombre, String Label, Posicion Pos, int Probabilidad, int Vida) {
		super(Nombre, Label, Pos, Probabilidad, Vida);
	}

	public void setVida(int i) {
		Vida = i;
		
	}
	
}