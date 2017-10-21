package Enemigos;

import Logica.Posicion;
import Objetos.Roca;
import entidades.Controlable;
import entidades.Enemigo;
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
		super ("ConArco", pos, 200, 5, 100, 125, 5, false, 2500);
		grafico = new EntidadGraficaEnemigo ("src\\Enemigos\\Sprites Enemigos\\ConArco.gif",pos);
	}

	@Override
	public void serAtacado(Controlable C) {
		C.atacar(this);
		
	}

	@Override
	public void atacar(Controlable A) {
		A.getEstado().setVida(A.getEstado().getVida() - calcularGolpe(A));
		
	}

	@Override
	public void atacar(Roca R) {
		R.setVida(R.getVida() - miEstadoActual.getAtaque()); 
		
	}

}