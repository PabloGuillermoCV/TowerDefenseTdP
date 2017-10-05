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