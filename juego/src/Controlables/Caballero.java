package Controlables;

import Logica.Posicion;
import Logica.Visitor;
import entidades.Controlable;
import entidades.Enemigo;

public class Caballero extends Controlable {
	
	/*
	Nombre = "Caballero"
	JLabel = Caballero.gif
	Posicion = pos
	Vida = 50
	Alcance = 2
	PowerUpDelMapa = null
	Ataque = 75
	Defensa = 90
	Precio = 500
	DosEspacios = False
	VelocidadAt = 9
	PowerUpComprado = null
	*/
	
	public Caballero (Posicion pos) {
		super ("Caballero", "src\\Controlables\\Sprites Controlables\\CaballeroStatic.gif", pos, 50, 2, null, 75, 90, 500, false, 9, null);
		this.grafico.setBounds (getPos ().getX (), getPos ().getY (), 20, 20);
	}

	@Override
	public void accept(Visitor V, Controlable P) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accept(Visitor V, Enemigo E) {
		// TODO Auto-generated method stub
		
	}
}