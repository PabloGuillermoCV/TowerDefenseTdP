package Enemigos;

import entidades.Disparos.Flecha;
import Logica.Posicion;
import Objetos.ObjResistente.Roca;
import entidades.Controlable;
import entidades.Enemigo;
import entidades.Proyectil;
import entidades.EntidadesGraficas.EntidadGraficaEnemigo;

public class ConBallesta extends Enemigo {
	
	/*
	Nombre = "ConBallesta"
	JLabel = ConBallesta.gif
	Posicion = pos
	Vida = 150
	Alcance = 5
	Ataque = 150
	Defensa = 200
	VelocidadMov = 2
	PowerUp = False
	Puntaje = 3000
	*/
	
	public ConBallesta (Posicion pos) {
		super ("ConBallesta", pos, 150, 2, 150, 200, 2, false, 300, 3000);
		grafico = new EntidadGraficaEnemigo ("src\\Enemigos\\Sprites Enemigos\\ConBallesta.gif",pos,this);
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