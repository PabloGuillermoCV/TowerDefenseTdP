package Controlables;

import Logica.Posicion;
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
	*/
	
	public Caballero (Posicion pos) {
		super ("Caballero", "src\\Controlables\\Sprites Controlables\\Caballero.gif", pos, 50, 2, null, 75, 90, 500, false, 9);
		this.grafico.setBounds (getPos ().getX (), getPos ().getY (), 20, 20);
	}
}