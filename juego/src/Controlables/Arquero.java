package Controlables;

import Logica.Posicion;
import entidades.Controlable;

public class Arquero extends Controlable {
	
	/*
	Nombre = "Arquero"
	JLabel = Arquero.gif
	Posicion = pos
	Vida = 100
	Alcance = 5
	PowerUpDelMapa = null
	Ataque = 50
	Defensa = 100
	Precio = 300
	DosEspacios = False
	VelocidadAt = 7
	*/
	
	public Arquero (Posicion pos) {
		super ("Arquero", "src\\Controlables\\Sprites Controlables\\Arquero.gif", pos, 100, 5, null, 50, 100, 300, false, 7);
		this.grafico.setBounds (getPos ().getX (), getPos ().getY (), 20, 20);
	}
}