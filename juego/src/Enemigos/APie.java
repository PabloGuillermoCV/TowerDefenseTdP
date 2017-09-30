package Enemigos;

import Logica.Posicion;
import Logica.Visitor;
import entidades.Controlable;
import entidades.Enemigo;

public class APie extends Enemigo {
	
	/*
	Nombre = "APie"
	JLabel = APie.gif
	Posicion = pos
	Vida = 50
	Alcance = 1
	PowerUpDelMapa = null
	Ataque = 50
	Defensa = 100
	VelocidadMov = 5
	PowerUp = False
	Puntaje = 1000
	*/
	
	public APie (Posicion pos) {
		super ("APie", "src\\Enemigos\\Sprites Enemigos\\APie.gif", pos, 50, 1, null, 50, 100, 5, false, 1000);
		this.grafico.setBounds (getPos ().getX (), getPos ().getY (), 20, 20);
	}

	@Override
	public void accept(Visitor V, Controlable P) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accept(Visitor V, Enemigo E) {
		// TODO Auto-generated method stub
		
	}
}