package Controlables;

import Logica.Posicion;
import entidades.Controlable;
import entidades.Enemigo;
import entidades.EntidadesGraficas.EntidadGraficaNoEnemigo;

@SuppressWarnings("unused")
public class Arquero extends Controlable {
	
	/*
	Nombre = "Arquero"
	JLabel = Arquero.gif
	Posicion = pos
	Vida = 200
	Alcance = 5
	Ataque = 100
	Defensa = 125
	Precio = 300
	VelocidadAt = 7
	*/
	
	public Arquero (Posicion pos) {
		super ("Arquero", pos, 200, 5, 50, 125, 300, 7);
		this.grafico = new EntidadGraficaNoEnemigo ("src\\Controlables\\Sprites Controlables\\ArqueroStatic.gif",pos);
	}
}