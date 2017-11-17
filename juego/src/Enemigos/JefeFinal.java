package Enemigos;

import Logica.Posicion;
import entidades.Enemigo;
import entidades.EntidadesGraficas.EntidadGraficaEnemigo;

public class JefeFinal extends Enemigo {
	
	/*
	Nombre = "JefeFinal"
	JLabel = JefeFinal.gif
	Posicion = pos
	Vida = 750
	Alcance = 4
	Ataque = 85
	Defensa = 350
	VelocidadMov = 4
	PowerUp = False
	Puntaje = 10000
	*/
	
	public JefeFinal (Posicion pos) {
		super ("JefeFinal", pos, 750, 4, 85, 350, 4, false, 1000, 10000);
		grafico = new EntidadGraficaEnemigo ("src\\Enemigos\\Sprites Enemigos\\JefeFinal.gif",pos,this);
	}
}