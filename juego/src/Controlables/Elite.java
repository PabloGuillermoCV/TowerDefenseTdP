package Controlables;

import Logica.Posicion;
import entidades.Controlable;
import entidades.EntidadesGraficas.EntidadGraficaNoEnemigo;

public class Elite extends Controlable {
	
	/*
	Nombre = "Elite"
	JLabel = Elite.gif
	Posicion = pos
	Vida = 300
	Alcance = 1
	Ataque = 150
	Defensa = 300
	Precio = 650
	VelocidadAt = 6
	*/
	
	public Elite (Posicion pos) {
		super ("Elite", pos, 300, 1, 150, 300, 650, 6);
		grafico = new EntidadGraficaNoEnemigo ("src\\Controlables\\Sprites Controlables\\EliteStatic.gif",pos);
	}
}