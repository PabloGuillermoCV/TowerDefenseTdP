package Enemigos;

import Logica.Posicion;
import entidades.enemigo;

public class ConBallesta extends enemigo {
	
	/*
	Nombre = "ConBallesta"
	JLabel = ConBallesta.gif
	Posicion = pos
	Vida = 150
	Alcance = 5
	PowerUpDelMapa = null
	Ataque = 150
	Defensa = 200
	VelocidadMov = 2
	PowerUp = False
	*/
	
	public ConBallesta (Posicion pos) {
		super ("ConBallesta", "src\\Enemigos\\Sprites Enemigos\\ConBallesta.gif", pos, 150, 2, null, 150, 200, 2, false);
		this.grafico.setBounds (getPos ().getX (), getPos ().getY (), 20, 20);
	}
}