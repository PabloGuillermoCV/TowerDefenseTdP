package Controlables;

import Logica.Posicion;
import entidades.Controlable;
import entidades.Enemigo;
import entidades.EntidadesGraficas.EntidadGraficaNoEnemigo;

@SuppressWarnings("unused")
public class Caballero extends Controlable {
	
	/*
	Nombre = "Caballero"
	JLabel = Caballero.gif
	Posicion = pos
	Vida = 300
	Alcance = 3
	Ataque = 70
	Defensa = 200
	Precio = 500
	VelocidadAt = 9
	*/
	
	public Caballero (Posicion pos) {
		super ("Caballero", pos, 300, 3, 70, 200, 500, 9);
		this.grafico = new EntidadGraficaNoEnemigo ("src\\Controlables\\Sprites Controlables\\CaballeroStatic.gif",pos);
	}
}