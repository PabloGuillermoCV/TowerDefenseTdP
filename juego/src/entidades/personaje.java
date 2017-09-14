package entidades;

import javax.swing.JLabel;
import Mapa.Posicion;

public abstract class personaje extends fisico {

	protected int Vida;
	protected int Alcance;
	protected PowerUpDelMapa PowerUp;
	protected int Ataque;
	protected int Defensa;
	
	public personaje (String Nombre, JLabel Label, Posicion Pos,int Vida, int Alcance,
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
	
	public void serAtacado (personaje P) {
		
	}
	
	public void Atacar (personaje P) {
		P.serAtacado (this);
	}
}