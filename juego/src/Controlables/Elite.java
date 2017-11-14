package Controlables;

import entidades.Disparos.Espadazo;
import Logica.Posicion;
import entidades.Controlable;
import entidades.Enemigo;
import entidades.Proyectil;
import entidades.EntidadesGraficas.EntidadGraficaNoEnemigo;

@SuppressWarnings("unused")
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
		this.grafico = new EntidadGraficaNoEnemigo ("src\\Controlables\\Sprites Controlables\\EliteStatic.gif",pos);
	}

	public void atacar(Enemigo E) {
		//Proyectil municion = new Espadazo(new Posicion (pos.getX(),pos.getY()), new Posicion (E.getPos().getX(), E.getPos().getY()));
		E.getEstado ().setVida (E.getEstado ().getVida () - calcularGolpe (E));
	}
}