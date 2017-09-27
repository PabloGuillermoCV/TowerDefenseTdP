package Enemigos;

import Logica.Posicion;
import entidades.enemigo;

public class ConArmadura extends enemigo {
	
	/*
	Nombre = "ConArmadura"
	JLabel = ConArmadura.gif
	Posicion = pos
	Vida = 450
	Alcance = 1
	PowerUpDelMapa = null
	Ataque = 200
	Defensa = 75
	VelocidadMov = 3
	PowerUp = False
	Puntaje = 4500
	*/
	
	public ConArmadura (Posicion pos) {
		super ("ConArmadura", "src\\Enemigos\\Sprites Enemigos\\ConArmadura.gif", pos, 450, 1, null, 200, 75, 3, false, 4500);
		this.grafico.setBounds (getPos ().getX (), getPos ().getY (), 20, 20);
	}
}