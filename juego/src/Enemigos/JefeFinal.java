package Enemigos;

import Logica.Posicion;
import Objetos.Roca;
import entidades.Controlable;
import entidades.Enemigo;

public class JefeFinal extends Enemigo {
	
	/*
	Nombre = "JefeFinal"
	JLabel = JefeFinal.gif
	Posicion = pos
	Vida = 500
	Alcance = 2
	PowerUpDelMapa = null
	Ataque = 250
	Defensa = 500
	VelocidadMov = 7
	PowerUp = False
	Puntaje = 10000
	*/
	
	public JefeFinal (Posicion pos) {
		super ("JefeFinal", "src\\Enemigos\\Sprites Enemigos\\JefeFinal.gif", pos, 500, 2, null, 250, 500, 7, false, 10000);
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