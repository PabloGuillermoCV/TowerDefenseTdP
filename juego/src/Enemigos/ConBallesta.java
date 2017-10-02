package Enemigos;

import Logica.Posicion;
import Logica.Visitor;
import entidades.Controlable;
import entidades.Enemigo;

public class ConBallesta extends Enemigo {
	
	/*
	Nombre = "ConBallesta"
	JLabel = ConBallesta.gif
	Posicion = pos
	Vida = 150
	Alcance = 5
	PowerUpDelMapa = null
	Ataque = 150
	Defensa = 200
	VelocidadMov = 2
	PowerUp = False
	Puntaje = 3000
	*/
	
	public ConBallesta (Posicion pos) {
		super ("ConBallesta", "src\\Enemigos\\Sprites Enemigos\\ConBallesta.gif", pos, 150, 2, null, 150, 200, 2, false, 3000);
		//this.grafico.setBounds (getPos ().getX (), getPos ().getY (), 20, 20);
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