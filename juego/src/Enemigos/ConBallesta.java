package Enemigos;

import Logica.Posicion;
import Objetos.Roca;
import entidades.Controlable;
import entidades.Enemigo;
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
		super ("ConBallesta", pos, 150, 2, 150, 200, 2, false, 3000);
		grafico = new EntidadGraficaEnemigo ("src\\Enemigos\\Sprites Enemigos\\ConBallesta.gif",pos);
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