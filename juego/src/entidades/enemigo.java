package entidades;

import java.awt.Graphics;

import javax.swing.JLabel;

import Mapa.Posicion;

public abstract class enemigo extends personaje {
	
	protected int VelocidadMov;
	protected boolean EfectoEspecial;
	
	public enemigo (String nombre, Graphics label, JLabel getLabel, Posicion Pos, int Width, int Height,
			int vida, int alcance, PowerUpDelMapa powerUp, int ataque, int defensa, int VelocidadMov,
			boolean EfectoEspecial) {
		super (nombre,label,getLabel,Pos,Width,Height,vida,alcance,powerUp,ataque,defensa);
		this.VelocidadMov = VelocidadMov;
		this.EfectoEspecial = EfectoEspecial;
	}
	
	public int getVelMov () {
		return 0;
	}
	
	public boolean getEfecto () {
		return true;
	}
}