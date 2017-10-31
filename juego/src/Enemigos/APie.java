package Enemigos;

import entidades.Disparos.Espadazo;
import Logica.Posicion;
import Objetos.ObjResistente.Roca;
import entidades.Controlable;
import entidades.Enemigo;
import entidades.Proyectil;
import entidades.EntidadesGraficas.EntidadGraficaEnemigo;

public class APie extends Enemigo {
	
	/*
	Nombre = "APie"
	JLabel = APie.gif
	Posicion = pos
	Vida = 50
	Alcance = 1
	Ataque = 50
	Defensa = 100
	VelocidadMov = 5
	PowerUp = False
	Puntaje = 1000
	*/
	
	public APie (Posicion pos) {
		super ("APie", pos, 50, 1, 50, 100, 5, false, 1000);
		grafico = new EntidadGraficaEnemigo ("src\\Enemigos\\Sprites Enemigos\\APie.gif",pos);
	}

	@Override
	public void atacar(Controlable C) {
		Proyectil municion = new Espadazo(pos,C.getPos());
		C.getEstado().setVida(C.getEstado().getVida() - calcularGolpe(C));
		
	}

	@Override
	public void atacar(Roca R) {
		Proyectil municion = new Espadazo(pos,R.getPos());
		R.setVida(R.getVida() - miEstadoActual.getAtaque()); 
		
	}

}