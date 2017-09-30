package Controlables;

import Logica.Posicion;
import Logica.Visitor;
import entidades.Controlable;
import entidades.Enemigo;

public class Elite extends Controlable {
	
	/*
	Nombre = "Elite"
	JLabel = Elite.gif
	Posicion = pos
	Vida = 350
	Alcance = 1
	PowerUpDelMapa = null
	Ataque = 150
	Defensa = 300
	Precio = 650
	DosEspacios = False
	VelocidadAt = 6
	PowerUpComprado = null
	*/
	
	public Elite (Posicion pos) {
		super ("Elite", "src\\Controlables\\Sprites Controlables\\EliteStatic.gif", pos, 350, 1, null, 150, 300, 650, false, 6, null);
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