package Enemigos;

import Logica.Posicion;
import entidades.enemigo;

public class ACaballo extends enemigo {
	
	/*
	Nombre = "ACaballo"
	JLabel = ACaballo.gif
	Posicion = pos
	Vida = 200
	Alcance = 2
	PowerUpDelMapa = null
	Ataque = 100
	Defensa = 90
	VelocidadMov = 6
	PowerUp = False
	*/
	
	public ACaballo (Posicion pos) {
		super ("ACaballo", "src\\Enemigos\\Sprites Enemigos\\ACaballo.gif", pos, 200, 2, null, 100, 90, 6, false);
		this.grafico.setBounds (getPos ().getX (), getPos ().getY (), 20, 20);
	}
}