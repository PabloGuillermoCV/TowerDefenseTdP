package Enemigos;

import Logica.Posicion;
import entidades.enemigo;

public class JefeFinal extends enemigo {
	
	/*
	Nombre = "JefeFinal"
	JLabel = JefeFinal.gif
	Posicion = pos
	Vida = 500
	Alcance = 2
	PowerUpDelMapa = null
	Ataque = 250
	Defensa = 500
	VelocidadMov = 7
	PowerUp = False
	Puntaje = 10000
	*/
	
	public JefeFinal (Posicion pos) {
		super ("JefeFinal", "src\\Enemigos\\Sprites Enemigos\\JefeFinal.gif", pos, 500, 2, null, 250, 500, 7, false, 10000);
		this.grafico.setBounds (getPos ().getX (), getPos ().getY (), 20, 20);
	}
}