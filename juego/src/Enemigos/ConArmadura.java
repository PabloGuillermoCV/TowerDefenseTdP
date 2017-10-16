package Enemigos;

import Logica.Posicion;
import Objetos.Roca;
import entidades.Controlable;
import entidades.Enemigo;

public class ConArmadura extends Enemigo {
	
	/*
	Nombre = "ConArmadura"
	JLabel = ConArmadura.gif
	Posicion = pos
	Vida = 450
	Alcance = 1
	PowerUpDelMapa = null
	Ataque = 200
	Defensa = 75
	VelocidadMov = 3
	PowerUp = False
	Puntaje = 4500
	*/
	
	public ConArmadura (Posicion pos) {
		super ("ConArmadura", "src\\Enemigos\\Sprites Enemigos\\ConArmadura.gif", pos, 450, 1, null, 200, 75, 3, false, 4500);
		//this.grafico.setBounds (getPos ().getX (), getPos ().getY (), 20, 20);
	}

	@Override
	public void serAtacado(Controlable C) {
		C.atacar(this);
		
	}

	@Override
	public void atacar(Controlable A) {
		A.setVida(A.getVida() - calcularGolpe(A));
		
	}

	@Override
	public void atacar(Roca R) {
		R.setVida(R.getVida() - Ataque); 
		
	}

}