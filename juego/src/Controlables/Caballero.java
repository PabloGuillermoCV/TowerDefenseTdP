package Controlables;

import entidades.Controlable;


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
	
	public Caballero () {
		super ("Caballero", "src\\Controlables\\Sprites Controlables\\CaballeroStatic.gif", null, 50, 2, null, 75, 90, 500, false, 9, null);
		//this.grafico.setBounds (getPos ().getX (), getPos ().getY (), 20, 20);
	}

}