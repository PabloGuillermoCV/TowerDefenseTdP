package Controlables;

import Enemigos.ACaballo;
import Enemigos.APie;
import Enemigos.ConArco;
import Enemigos.ConArmadura;
import Enemigos.ConBallesta;
import Enemigos.JefeFinal;
import entidades.Controlable;
import entidades.Enemigo;

public class Catapulta extends Controlable {
	
	/*
	Nombre = "Catapulta"
	JLabel = Catapulta.gif
	Posicion = pos
	Vida = 200
	Alcance = 3
	PowerUpDelMapa = null
	Ataque = 200
	Defensa = 100
	Precio = 500
	DosEspacios = True
	VelocidadAt = 2
	PowerUpComprado = null
	*/
	
	public Catapulta () {
		super ("Caballero", "src\\Controlables\\Sprites Controlables\\CatapultaStatic.gif", null, 200, 3, null, 200, 100, 5200, false, 2, null);
		//this.grafico.setBounds (getPos ().getX (), getPos ().getY (), 20, 20);
	}

	@Override
	public void serAtacado(Enemigo e) {
		e.atacar(this);
		
	}

	@Override
	public void atacar(ACaballo AC) {
		AC.setVida(AC.getVida() - calcularGolpe(AC));
	}

	@Override
	public void atacar(APie AP) { 
		AP.setVida(AP.getVida() - calcularGolpe(AP));
	}

	@Override
	public void atacar(ConArco AC) {
		AC.setVida(AC.getVida() - calcularGolpe(AC));		
	}

	@Override
	public void atacar(ConArmadura CA) {
		CA.setVida(CA.getVida() - calcularGolpe(CA));
	}

	@Override
	public void atacar(ConBallesta CB) {
		CB.setVida(CB.getVida() - calcularGolpe(CB));
	}

	@Override
	public void atacar(JefeFinal JF) {
		JF.setVida(JF.getVida() - calcularGolpe(JF));
	}
	
}