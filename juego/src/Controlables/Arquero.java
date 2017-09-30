package Controlables;

import Logica.Posicion;
import Logica.Visitor;
import entidades.Controlable;
import entidades.Enemigo;
import entidades.Personaje;

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
	
	public Arquero (Posicion pos) {
		super ("Arquero", "src\\Controlables\\Sprites Controlables\\ArqueroStatic.gif", pos, 100, 5, null, 50, 100, 300, false, 7, null);
		this.grafico.setBounds (getPos ().getX (), getPos ().getY (), 20, 20);
	}

	public void accept(Visitor V, Controlable P) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accept(Visitor V, Enemigo E) {
		// TODO Auto-generated method stub
		
	}
}