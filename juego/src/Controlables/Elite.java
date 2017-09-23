package Controlables;

import Logica.Posicion;
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
	*/
	
	public Elite (Posicion pos) {
		super ("Elite", "src\\Controlables\\Sprites Controlables\\Elite.gif", pos, 350, 1, null, 150, 300, 650, false, 6);
		this.grafico.setBounds (getPos ().getX (), getPos ().getY (), 20, 20);
	}
}