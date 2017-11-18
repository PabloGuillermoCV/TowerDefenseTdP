package Controlables;

import Logica.Posicion;
import entidades.Controlable;
import entidades.Enemigo;
import entidades.EntidadesGraficas.EntidadGraficaNoEnemigo;

@SuppressWarnings("unused")
public class Elite extends Controlable {
	
	/*
	Nombre = "Elite"
	JLabel = Elite.gif
	Posicion = pos
	Vida = 400
	Alcance = 4
	Ataque = 85
	Defensa = 200
	Precio = 650
	VelocidadAt = 6
	*/
	
	public Elite (Posicion pos) {
		super ("Elite", pos, 400, 3, 75, 200, 650, 6);
		this.grafico = new EntidadGraficaNoEnemigo ("src\\Controlables\\Sprites Controlables\\EliteStatic.gif",pos);
	}
}