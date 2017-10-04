package Enemigos;

import Controlables.Arquero;
import Controlables.Caballero;
import Controlables.Catapulta;
import Controlables.Elite;
import Controlables.Soldado;
import Logica.Posicion;
import Objetos.Roca;
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
		//this.grafico.setBounds (getPos ().getX (), getPos ().getY (), 20, 20);
	}

	@Override
	public void serAtacado(Controlable C) {
		C.atacar(this);
		
	}

	@Override
	public void atacar(Arquero A) {
		A.setVida(A.getVida() - calcularGolpe(A));
		
	}

	@Override
	public void atacar(Caballero C) {
		C.setVida(C.getVida() - calcularGolpe(C));		
	}

	@Override
	public void atacar(Elite E) {
		E.setVida(E.getVida() - calcularGolpe(E));		
	}

	@Override
	public void atacar(Soldado S) {
		S.setVida(S.getVida() - calcularGolpe(S));
	}

	@Override
	public void atacar(Catapulta C) {
		C.setVida(C.getVida() - calcularGolpe(C));
		
	}

	@Override
	public void atacar(Roca R) {
		 R.setVida(R.getVida() - Ataque); 
		
	}

}