package Controlables;

import entidades.Controlable;


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
	
	public Elite () {
		super ("Elite", "src\\Controlables\\Sprites Controlables\\EliteStatic.gif", null, 350, 1, null, 150, 300, 650, false, 6, null);
		//this.grafico.setBounds (getPos ().getX (), getPos ().getY (), 20, 20);
	}
}