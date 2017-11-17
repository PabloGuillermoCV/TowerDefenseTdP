package Enemigos;

import Logica.Posicion;
import entidades.Enemigo;
import entidades.EntidadesGraficas.EntidadGraficaEnemigo;

public class APie extends Enemigo {
	
	/*
	Nombre = "APie"
	JLabel = APie.gif
	Posicion = pos
	Vida = 100
	Alcance = 2
	Ataque = 70
	Defensa = 100
	VelocidadMov = 2
	PowerUp = False
	Puntaje = 1000
	*/
	
	public APie (Posicion pos) {
		super ("APie", pos, 100, 2, 70, 100, 2, false, 100, 1000);
		grafico = new EntidadGraficaEnemigo ("src\\Enemigos\\Sprites Enemigos\\APie.gif",pos,this);
	}
}