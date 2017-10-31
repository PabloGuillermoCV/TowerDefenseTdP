package Controlables;

import entidades.Disparos.Espadazo;
import Logica.Posicion;
import entidades.Controlable;
import entidades.Enemigo;
import entidades.Proyectil;
import entidades.EntidadesGraficas.EntidadGraficaNoEnemigo;

public class Soldado extends Controlable {
	
	/*
	Nombre = "Soldado"
	JLabel = Soldado.gif
	Posicion = pos
	Vida = 100
	Alcance = 1
	Ataque = 50
	Defensa = 100
	Precio = 200
	VelocidadAt = 4
	*/
	
	
	public Soldado (Posicion pos) {
		super ("Soldado", pos, 100, 1, 50, 100, 200, 4);
		grafico = new EntidadGraficaNoEnemigo ("src\\Controlables\\Sprites Controlables\\SoldadoStatic.gif",pos);
	}

	@Override
	public void atacar(Enemigo E) {
		Proyectil municion = new Espadazo(pos,E.getPos());
		E.getEstado().setVida( E.getEstado().getVida() - calcularGolpe(E));
		
	}
}