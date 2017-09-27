package Enemigos;

import Logica.Posicion;
import entidades.enemigo;

public class ConArco extends enemigo {
	
	/*
	Nombre = "ConArco"
	JLabel = ConArco.gif
	Posicion = pos
	Vida = 200
	Alcance = 5
	PowerUpDelMapa = null
	Ataque = 100
	Defensa = 125
	VelocidadMov = 5
	PowerUp = False
	Puntaje = 2500
	*/
	
	public ConArco (Posicion pos) {
		super ("ConArco", "src\\Enemigos\\Sprites Enemigos\\ConArco.gif", pos, 200, 5, null, 100, 125, 5, false, 2500);
		this.grafico.setBounds (getPos ().getX (), getPos ().getY (), 20, 20);
	}
}