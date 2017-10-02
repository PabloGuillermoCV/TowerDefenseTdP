package Controlables;

import Logica.Visitor;
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
	public void accept(Visitor V, Controlable P) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accept(Visitor V, Enemigo E) {
		// TODO Auto-generated method stub
		
	}
}