package Controlables;

import entidades.Disparos.CargaCatapulta;
import Logica.Posicion;
import entidades.Controlable;
import entidades.Enemigo;
import entidades.Proyectil;
import entidades.EntidadesGraficas.EntidadGraficaNoEnemigo;

public class Catapulta extends Controlable {
	
	protected Posicion pos2;
	
	/*
	Nombre = "Catapulta"
	JLabel = Catapulta.gif
	Posicion = pos
	Vida = 200
	Alcance = 3
	Ataque = 50
	Defensa = 100
	Precio = 500
	VelocidadAt = 2
	*/
	
	public Catapulta (Posicion pos) {
		super ("Caballero", pos, 200, 3, 5000, 100, 500, 2);
		grafico = new EntidadGraficaNoEnemigo ("src\\Controlables\\Sprites Controlables\\CatapultaStatic.gif",pos);
		pos2 = new Posicion (pos.getX () + 20, pos.getY () + 20);
	}

	@SuppressWarnings("unused")
	public void atacar(Enemigo E) {
		//Proyectil municion = new CargaCatapulta(new Posicion (pos.getX(),pos.getY()), new Posicion (E.getPos().getX(), E.getPos().getY()));
		E.getEstado().setVida( E.getEstado().getVida() - calcularGolpe(E));
	}
}