package entidades;

import Logica.Posicion;

public abstract class Personaje extends Fisico {

	protected int Vida;
	protected int Alcance;
	protected PowerUpDelMapa PowerUp;
	protected int Ataque;
	protected int Defensa;
	
	public Personaje (String Nombre, String Label, Posicion Pos, int Vida, int Alcance,
			PowerUpDelMapa PowerUp, int Ataque, int Defensa) {
		super (Nombre,Label,Pos);
		this.Vida = Vida;
		this.Alcance = Alcance;
		this.PowerUp = PowerUp;
		this.Ataque = Ataque;
		this.Defensa = Defensa;
	}
	
	public int getVida () {
		return Vida;
	}
	
	public int getAlcance () {
		return Alcance;
	}
	
	public PowerUpDelMapa getPoder () {
		return PowerUp;
	}
	
	public int getAtaque () {
		return Ataque;
	}
	
	public int getDefensa () {
		return Defensa;
	}
	
	public void setVida (int V) {
		Vida = V;
	}
	
	public void setPowerUp (PowerUpDelMapa P) {
		PowerUp = P;
	}
	
	public abstract void serAtacado(Controlable a);
	
	public abstract void serAtacado(Enemigo e);
	
	public void serAtacado (Personaje P) {}
	
	public void Atacar (Personaje P) {
		P.serAtacado (this);
	}
}