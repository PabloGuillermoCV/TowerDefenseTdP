package Enemigos;

import Logica.Posicion;
import Logica.Visitor;
import entidades.Controlable;
import entidades.Enemigo;

public class ConArco extends Enemigo {
	
	/*
	Nombre = "ConArco"
	JLabel = ConArco.gif
	Posicion = pos
	Vida = 200
	Alcance = 5
	PowerUpDelMapa = null
	Ataque = 100
	Defensa = 125
	VelocidadMov = 5
	PowerUp = False
	Puntaje = 2500
	*/
	
	public ConArco (Posicion pos) {
		super ("ConArco", "src\\Enemigos\\Sprites Enemigos\\ConArco.gif", pos, 200, 5, null, 100, 125, 5, false, 2500);
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