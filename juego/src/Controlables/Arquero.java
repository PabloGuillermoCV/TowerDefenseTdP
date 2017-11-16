package Controlables;

import entidades.Disparos.Flecha;
import Logica.Posicion;
import entidades.Controlable;
import entidades.Enemigo;
import entidades.Proyectil;
import entidades.EntidadesGraficas.EntidadGraficaNoEnemigo;

@SuppressWarnings("unused")
public class Arquero extends Controlable {
	
	/*
	Nombre = "Arquero"
	JLabel = Arquero.gif
	Posicion = pos
	Vida = 100
	Alcance = 5
	Ataque = 50
	Defensa = 100
	Precio = 300
	VelocidadAt = 7
	*/
	
	public Arquero (Posicion pos) {
		super ("Arquero", pos, 100, 5, 50, 100, 300, 7);
		this.grafico = new EntidadGraficaNoEnemigo ("src\\Controlables\\Sprites Controlables\\ArqueroStatic.gif",pos);
	}
}