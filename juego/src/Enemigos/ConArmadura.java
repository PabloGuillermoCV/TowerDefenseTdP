package Enemigos;

import entidades.Disparos.Espadazo;
import Logica.Posicion;
import Objetos.ObjResistente.Roca;
import entidades.Controlable;
import entidades.Enemigo;
import entidades.Proyectil;
import entidades.EntidadesGraficas.EntidadGraficaEnemigo;

public class ConArmadura extends Enemigo {
	
	/*
	Nombre = "ConArmadura"
	JLabel = ConArmadura.gif
	Posicion = pos
	Vida = 450
	Alcance = 1
	Ataque = 200
	Defensa = 75
	VelocidadMov = 3
	PowerUp = False
	Puntaje = 4500
	*/
	
	public ConArmadura (Posicion pos) {
		super ("ConArmadura", pos, 450, 1, 200, 75, 3, false, 4500);
		grafico = new EntidadGraficaEnemigo ("src\\Enemigos\\Sprites Enemigos\\ConArmadura.gif",pos);
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