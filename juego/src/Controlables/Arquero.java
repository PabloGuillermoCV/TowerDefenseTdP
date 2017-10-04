package Controlables;

import Enemigos.ACaballo;
import Enemigos.APie;
import Enemigos.ConArco;
import Enemigos.ConArmadura;
import Enemigos.ConBallesta;
import Enemigos.JefeFinal;
import entidades.Controlable;
import entidades.Enemigo;

public class Arquero extends Controlable {
	
	/*
	Nombre = "Arquero"
	JLabel = Arquero.gif
	Posicion = pos
	Vida = 100
	Alcance = 5
	PowerUpDelMapa = null
	Ataque = 50
	Defensa = 100
	Precio = 300
	DosEspacios = False
	VelocidadAt = 7
	PowerUpComprado = null
	*/
	
	public Arquero () {
		super ("Arquero", "src\\Controlables\\Sprites Controlables\\ArqueroStatic.gif", null, 100, 5, null, 50, 100, 300, false, 7, null);
		//this.grafico.setBounds (getPos ().getX (), getPos ().getY (), 20, 20);
	}

	@Override
	public void serAtacado(Enemigo e) {
		// TODO Auto-generated method stub
		
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