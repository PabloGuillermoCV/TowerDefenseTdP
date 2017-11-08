package entidades;

import Logica.MapaLogico;
import Logica.Posicion;
import Objetos.ObjsDeLaTienda.Explosivo;
import entidades.Estados.Estado;
import entidades.Estados.EstadoNormal;

public abstract class Personaje extends Entidad {
	
	protected Estado miEstadoActual;
	protected int Alcance;
	protected MapaLogico miMapa;
	protected int VidaMax;
	protected int AtaqueMax;
	protected int DefensaMax;
	protected boolean estoyMuerto;
	
	public Personaje (String Nombre, Posicion Pos, int Vida, int Alcance, 
			int Ataque, int Defensa) {
		super (Nombre, Pos);
		this.Alcance = Alcance;
		this.miEstadoActual = new EstadoNormal (Vida, Ataque, Defensa);
		this.miMapa = MapaLogico.InstanciaMapaLogico ();
		this.VidaMax = Vida;
		this.AtaqueMax = Ataque;
		this.DefensaMax = Defensa;
		estoyMuerto=false;
	}
	public boolean estoyMuerto() {
		return estoyMuerto;
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
	
	public void serAtacado (Explosivo E){
		E.Atacar (this);
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