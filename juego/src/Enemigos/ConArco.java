package Enemigos;

import entidades.Disparos.Flecha;
import Logica.Posicion;
import Objetos.ObjResistente.Roca;
import entidades.Controlable;
import entidades.Enemigo;
import entidades.Proyectil;
import entidades.EntidadesGraficas.EntidadGraficaEnemigo;

public class ConArco extends Enemigo {
	
	/*
	Nombre = "ConArco"
	JLabel = ConArco.gif
	Posicion = pos
	Vida = 200
	Alcance = 5
	Ataque = 100
	Defensa = 125
	VelocidadMov = 5
	PowerUp = False
	Puntaje = 2500
	*/
	
	public ConArco (Posicion pos) {
		super ("ConArco", pos, 200, 5, 100, 125, 5, false, 250, 2500);
		grafico = new EntidadGraficaEnemigo ("src\\Enemigos\\Sprites Enemigos\\ConArco.gif",pos,this);
	}

	@SuppressWarnings("unused")
	public void atacar(Controlable C) {
		Proyectil municion = new Flecha(pos,C.getPos());
		C.getEstado().setVida(C.getEstado().getVida() - calcularGolpe(C));
		
	}

	@SuppressWarnings("unused")
	public void atacar(Roca R) {
		Proyectil municion = new Flecha(pos,R.getPos());
		R.setVida(R.getVida() - miEstadoActual.getAtaque()); 		
	}
}