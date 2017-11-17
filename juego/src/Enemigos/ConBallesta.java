package Enemigos;

import Logica.Posicion;
import entidades.Enemigo;
import entidades.EntidadesGraficas.EntidadGraficaEnemigo;

public class ConBallesta extends Enemigo {
	
	/*
	Nombre = "ConBallesta"
	JLabel = ConBallesta.gif
	Posicion = pos
	Vida = 250
	Alcance = 5
	Ataque = 50
	Defensa = 175
	VelocidadMov = 2
	PowerUp = False
	Puntaje = 3000
	*/
	
	public ConBallesta (Posicion pos) {
		super ("ConBallesta", pos, 250, 5, 50, 175, 2, false, 300, 3000);
		grafico = new EntidadGraficaEnemigo ("src\\Enemigos\\Sprites Enemigos\\ConBallesta.gif",pos,this);
	}
}