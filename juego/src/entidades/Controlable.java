package entidades;

import java.awt.Graphics;

import javax.swing.JLabel;

import Mapa.Posicion;

public abstract class Controlable extends personaje {
	
	protected int Precio;
	protected int Espacio [];
	protected int VelocidadAt;
	
	public Controlable (String nombre, Graphics label, JLabel getLabel, Posicion Pos, int Width, int Height,
			int vida, int alcance, PowerUpDelMapa powerUp, int ataque, int defensa, int Precio,
			int Espacio [], int VelocidadAt) {
		super (nombre,label,getLabel,Pos,Width,Height,vida,alcance,powerUp,ataque,defensa);
		this.Precio = Precio;
		this.Espacio = Espacio;
		this.VelocidadAt = VelocidadAt;
	}
	
	public int getPrecio () {
		return Precio;
	}
	
	public int [] getEspacio () {
		return Espacio;
	}
	
	public int getVelAt () {
		return VelocidadAt;
	}
}