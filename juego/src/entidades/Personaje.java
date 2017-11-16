package entidades;

import Logica.Posicion;
import entidades.Estados.Estado;
import entidades.Estados.EstadoNormal;

public abstract class Personaje extends Entidad {
	
	protected Estado miEstadoActual;
	protected int Alcance;
	protected int VidaMax;
	protected int AtaqueMax;
	protected int DefensaMax;
	protected boolean estoyMuerto;
	protected boolean estoyEnInteraccion;
	
	public Personaje (String Nombre, Posicion Pos, int Vida, int Alcance, 
			int Ataque, int Defensa) {
		super (Nombre, Pos);
		this.Alcance = Alcance;
		this.miEstadoActual = new EstadoNormal (Vida, Ataque, Defensa);
		this.VidaMax = Vida;
		this.AtaqueMax = Ataque;
		this.DefensaMax = Defensa;
		this.estoyMuerto = false;
		this.estoyEnInteraccion = false;
	}
	
	public boolean estoyMuerto () {
		return estoyMuerto;
	}
	
	public boolean estoyEnInteraccion () {
		return estoyEnInteraccion;
	}
	
	public abstract void morir ();
	
	public Estado getEstado () {
		return miEstadoActual;
	}
	
	public int getAlcance () {
		return Alcance;
	}
	
	public void setEstado (Estado e) {
		miEstadoActual = e;
	}
	
	public int getVidaMax () {
		return VidaMax;
	}
	
	public int getAtaqueMax () {
		return AtaqueMax;
	}
	
	public int getDefensaMax () {
		return DefensaMax;
	}
}