package Controlables;

import Logica.Posicion;
import entidades.Controlable;
import entidades.Enemigo;
import entidades.EntidadesGraficas.EntidadGrafica;
import entidades.EntidadesGraficas.EntidadGraficaNoEnemigo;

@SuppressWarnings("unused")
public class Catapulta extends Controlable {
	
	/*
	Nombre = "Catapulta"
	JLabel = Catapulta.gif
	Posicion = pos
	Vida = 200
	Alcance = 4
	Ataque = 75
	Defensa = 100
	Precio = 500
	VelocidadAt = 2
	*/
	
	public Catapulta (Posicion pos) {
		super ("Caballero", pos, 200, 4, 75, 100, 500, 2);
		this.Pos2 = new Posicion (pos.getX () + 20, pos.getY ());
		this.miMapa.getCelda (this.Pos2.getX (), this.Pos2.getY ()).addPersonaje (this);;
		this.grafico = new EntidadGraficaNoEnemigo ("src\\Controlables\\Sprites Controlables\\CatapultaStatic.gif", pos);
		this.GraficoAuxiliar = new EntidadGraficaNoEnemigo ("src\\Controlables\\Sprites Controlables\\CargaCatapulta.png", this.Pos2);
	}
}