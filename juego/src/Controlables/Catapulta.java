package Controlables;

import Logica.Posicion;
import entidades.Controlable;

public class Catapulta extends Controlable {
	
	/*
	Nombre = "Catapulta"
	JLabel = Catapulta.gif
	Posicion = pos
	Vida = 200
	Alcance = 3
	PowerUpDelMapa = null
	Ataque = 200
	Defensa = 100
	Precio = 500
	DosEspacios = True
	VelocidadAt = 2
	PowerUpComprado = null
	*/
	
	public Catapulta (Posicion pos) {
		super ("Caballero", "src\\Controlables\\Sprites Controlables\\CatapultaStatic.gif", pos, 200, 3, null, 200, 100, 5200, false, 2, null);
		this.grafico.setBounds (getPos ().getX (), getPos ().getY (), 20, 20);
	}
}