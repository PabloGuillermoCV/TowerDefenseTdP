package Enemigos;

import entidades.Disparos.Espadazo;
import Logica.Posicion;
import Objetos.ObjResistente.Roca;
import entidades.Controlable;
import entidades.Enemigo;
import entidades.Proyectil;
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
		super ("JefeFinal", pos, 500, 2, 250, 500, 7, false, 1000, 10000);
		grafico = new EntidadGraficaEnemigo ("src\\Enemigos\\Sprites Enemigos\\JefeFinal.gif",pos,this);
	}

	@SuppressWarnings("unused")
	public void atacar(Controlable C) {
		Proyectil municion = new Espadazo(pos,C.getPos());
		C.getEstado().setVida(C.getEstado().getVida() - calcularGolpe(C));
		
	}

	@SuppressWarnings("unused")
	public void atacar(Roca R) {
		Proyectil municion = new Espadazo(pos,R.getPos());
		R.setVida(R.getVida() - miEstadoActual.getAtaque()); 
		
	}
}