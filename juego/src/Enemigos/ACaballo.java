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

public class ACaballo extends Enemigo {
	
	/*
	Nombre = "ACaballo"
	JLabel = ACaballo.gif
	Posicion = pos
	Vida = 200
	Alcance = 2
	PowerUpDelMapa = null
	Ataque = 100
	Defensa = 90
	VelocidadMov = 6
	PowerUp = False
	Puntaje = 5000
	*/
	
	public ACaballo (Posicion pos) {
		super ("ACaballo", "src\\Enemigos\\Sprites Enemigos\\ACaballo.gif", pos, 200, 2, null, 100, 90, 6, false, 5000);
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