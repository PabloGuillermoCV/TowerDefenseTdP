package entidades;

import java.awt.Graphics;
import javax.swing.JLabel;
import Mapa.*;

public class Soldado extends Controlable {
	
	private String Nombre = "Soldado";
	private Graphics Label;
	JLabel getLabel;
	Posicion Pos;
	int Width;
	int Height;
	int Vida = 50;
	int Alcance = 1;
	PowerUpDelMapa PowerUp;
	int Ataque = 50;
	int Defensa = 100;
	int Precio = 200;
	int Espacio [] = new int [2];
	int VelocidadAt = 4;
	
	public Soldado () { //falta consultar unas cosas sobre herencia
		super (Nombre,Label,getLabel,Pos,Width,Height,Vida,Alcancel,PowerUp,Ataque,Defensa,Precio,Espacio,VelocidadAt);
	}
}