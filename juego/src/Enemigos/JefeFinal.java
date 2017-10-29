package Enemigos;

import entidades.Disparos.Espadazo;
import Logica.Posicion;
import entidades.Enemigo;
import entidades.EntidadesGraficas.EntidadGraficaEnemigo;

public class JefeFinal extends Enemigo {
	
	/*
	Nombre = "JefeFinal"
	JLabel = JefeFinal.gif
	Posicion = pos
	Vida = 500
	Alcance = 2
	Ataque = 250
	Defensa = 500
	VelocidadMov = 7
	PowerUp = False
	Puntaje = 10000
	*/
	
	public JefeFinal (Posicion pos) {
		super ("JefeFinal", pos, 500, 2, 250, 500, 7, false, 10000);
		grafico = new EntidadGraficaEnemigo ("src\\Enemigos\\Sprites Enemigos\\JefeFinal.gif",pos);
		miBala = new Espadazo(pos);
	}
}