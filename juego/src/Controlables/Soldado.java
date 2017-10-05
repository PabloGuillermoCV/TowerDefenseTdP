package Controlables;


import Enemigos.*;
import entidades.Controlable;
import entidades.Enemigo;

public class Soldado extends Controlable {
	
	/*
	Nombre = "Soldado"
	JLabel = Soldado.gif
	Posicion = pos
	Vida = 100
	Alcance = 1
	PowerUpDelMapa = null
	Ataque = 50
	Defensa = 100
	Precio = 200
	DosEspacios = False
	VelocidadAt = 4
	PowerUpComprado = null
	*/
	
	
	public Soldado () {
		super ("Soldado", "src\\Controlables\\Sprites Controlables\\SoldadoStatic.gif", null, 100, 1, null, 50, 100, 200, false, 4, null);
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