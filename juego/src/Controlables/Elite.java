package Controlables;

import Enemigos.ACaballo;
import Enemigos.APie;
import Enemigos.ConArco;
import Enemigos.ConArmadura;
import Enemigos.ConBallesta;
import Enemigos.JefeFinal;
import entidades.Controlable;
import entidades.Enemigo;

public class Elite extends Controlable {
	
	/*
	Nombre = "Elite"
	JLabel = Elite.gif
	Posicion = pos
	Vida = 350
	Alcance = 1
	PowerUpDelMapa = null
	Ataque = 150
	Defensa = 300
	Precio = 650
	DosEspacios = False
	VelocidadAt = 6
	PowerUpComprado = null
	*/
	
	public Elite () {
		super ("Elite", "src\\Controlables\\Sprites Controlables\\EliteStatic.gif", null, 350, 1, null, 150, 300, 650, false, 6, null);
		//this.grafico.setBounds (getPos ().getX (), getPos ().getY (), 20, 20);
	}

	@Override
	public void serAtacado(Enemigo e) {
		e.atacar(this);
		
	}

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