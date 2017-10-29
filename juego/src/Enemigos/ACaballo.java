package Enemigos;

import entidades.Disparos.Espadazo;
import Logica.Posicion;
import Objetos.ObjResistente.Roca;
import entidades.Controlable;
import entidades.Enemigo;
import entidades.Proyectil;
import entidades.EntidadesGraficas.EntidadGraficaEnemigo;

public class ACaballo extends Enemigo {
	
	/*
	Nombre = "ACaballo"
	JLabel = ACaballo.gif
	Posicion = pos
	Vida = 200
	Alcance = 2
	Ataque = 100
	Defensa = 90
	VelocidadMov = 6
	PowerUp = False
	Puntaje = 5000
	*/
	
	public ACaballo (Posicion pos) {
		super ("ACaballo", pos, 200, 2, 100, 90, 6, false, 5000);
		grafico = new EntidadGraficaEnemigo ("src\\Enemigos\\Sprites Enemigos\\ACaballo.gif",pos);
	}

	@Override
	public void atacar(Controlable C) {
		Proyectil municion = new Espadazo(pos);
		municion.volarAPosicion(C.getPos());
		C.getEstado().setVida(C.getEstado().getVida() - calcularGolpe(C));
		
	}

	@Override
	public void atacar(Roca R) {
		Proyectil municion = new Espadazo(pos);
		municion.volarAPosicion(R.getPos());
		R.setVida(R.getVida() - miEstadoActual.getAtaque()); 
		
	}

}