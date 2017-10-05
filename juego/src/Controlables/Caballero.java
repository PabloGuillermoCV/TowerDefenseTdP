package Controlables;


import Enemigos.ACaballo;
import Enemigos.APie;
import Enemigos.ConArco;
import Enemigos.ConArmadura;
import Enemigos.ConBallesta;
import Enemigos.JefeFinal;
import entidades.Controlable;
import entidades.Enemigo;

public class Caballero extends Controlable {
	
	/*
	Nombre = "Caballero"
	JLabel = Caballero.gif
	Posicion = pos
	Vida = 50
	Alcance = 2
	PowerUpDelMapa = null
	Ataque = 75
	Defensa = 90
	Precio = 500
	DosEspacios = False
	VelocidadAt = 9
	PowerUpComprado = null
	*/
	
	public Caballero () {
		super ("Caballero", "src\\Controlables\\Sprites Controlables\\CaballeroStatic.gif", null, 50, 2, null, 75, 90, 500, false, 9, null);
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