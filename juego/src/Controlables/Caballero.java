package Controlables;

import entidades.Disparos.Espadazo;
import Logica.Posicion;
import entidades.Controlable;
import entidades.Enemigo;
import entidades.Proyectil;
import entidades.EntidadesGraficas.EntidadGraficaNoEnemigo;

public class Caballero extends Controlable {
	
	/*
	Nombre = "Caballero"
	JLabel = Caballero.gif
	Posicion = pos
	Vida = 50
	Alcance = 2
	Ataque = 75
	Defensa = 90
	Precio = 500
	VelocidadAt = 9
	*/
	
	public Caballero (Posicion pos) {
		super ("Caballero", pos, 50, 2, 75, 90, 500, 9);
		grafico = new EntidadGraficaNoEnemigo ("src\\Controlables\\Sprites Controlables\\CaballeroStatic.gif",pos);
	}

	@SuppressWarnings("unused")
	public void atacar(Enemigo E) {
		Proyectil municion = new Espadazo(new Posicion (pos.getX(),pos.getY()), new Posicion (E.getPos().getX(), E.getPos().getY()));
		E.getEstado().setVida( E.getEstado().getVida() - calcularGolpe(E));
	}
}