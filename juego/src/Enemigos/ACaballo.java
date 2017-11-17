package Enemigos;

import Logica.Posicion;
import entidades.Enemigo;
import entidades.EntidadesGraficas.EntidadGraficaEnemigo;

public class ACaballo extends Enemigo {
	
	/*
	Nombre = "ACaballo"
	JLabel = ACaballo.gif
	Posicion = pos
	Vida = 250
	Alcance = 3
	Ataque = 80
	Defensa = 120
	VelocidadMov = 4
	PowerUp = False
	Puntaje = 5000
	*/
	
	public ACaballo (Posicion pos) {
		super ("ACaballo", pos, 250, 3, 80, 120, 4, false, 500, 5000);
		grafico = new EntidadGraficaEnemigo ("src\\Enemigos\\Sprites Enemigos\\ACaballo.gif",pos,this);
	}
}