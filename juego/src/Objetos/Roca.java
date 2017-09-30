package Objetos;

import Logica.Posicion;
import Logica.Visitor;
import entidades.Controlable;
import entidades.Enemigo;
import entidades.ObjetoResistente;


public class Roca extends ObjetoResistente {

	public Roca(String Nombre, String Label, Posicion Pos, int Probabilidad, int Vida) {
		super(Nombre, Label, Pos, Probabilidad, Vida);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accept(Visitor V, Enemigo E) {
		V.visit(this, E);
		
	}

	public void setVida(int i) {
		Vida = i;
		
	}

	@Override
	public void accept(Visitor V, Controlable P) {
		//Does Nothing
		
	}

	
}