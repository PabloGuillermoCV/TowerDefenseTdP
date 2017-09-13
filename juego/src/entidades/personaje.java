package entidades;

import java.awt.Graphics;

import javax.swing.JLabel;

import Mapa.Posicion;

public abstract class personaje extends fisico {

	protected int vida;
	protected int alcance;
	protected PowerUpDelMapa powerUp;
	protected int ataque;
	protected int defensa;
	
	public personaje (String nombre, Graphics label, JLabel getLabel, Posicion Pos, int Width, int Height,
			int vida, int alcance, PowerUpDelMapa powerUp, int ataque, int defensa) {
		super (nombre,label,getLabel,Pos,Width,Height);
		this.vida = vida;
		this.alcance = alcance;
		this.powerUp = powerUp;
		this.ataque = ataque;
		this.defensa = defensa;
	}
	
	public int getVida () {
		return vida;
	}
	
	public int getAlcance () {
		return alcance;
	}
	
	public PowerUpDelMapa getPoder () {
		return powerUp;
	}
	
	public int getAtaque () {
		return ataque;
	}
	
	public int getDefensa () {
		return defensa;
	}
	
	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}

	@Override
	public void atacar(entidad e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void efecto() {
		// TODO Auto-generated method stub

	}

	@Override
	public int morir() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int vender() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void mover() {
		// TODO Auto-generated method stub

	}

	@Override
	public void iniciarAtaque() {
		// TODO Auto-generated method stub

	}
}