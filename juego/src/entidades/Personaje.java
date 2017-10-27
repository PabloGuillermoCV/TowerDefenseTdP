package entidades;

import Logica.MapaLogico;
import Logica.Posicion;
import entidades.Estados.Estado;
import entidades.Estados.EstadoNormal;

public abstract class Personaje extends Entidad {
	
	protected Estado miEstadoActual;
	protected int Alcance;
	protected Proyectil miBala;
	protected MapaLogico miMapa;
	
	public Personaje (String Nombre, Posicion Pos, int Vida, int Alcance, 
			int Ataque, int Defensa) {
		super (Nombre, Pos);
		this.Alcance = Alcance;
		this.miEstadoActual = new EstadoNormal (Vida, Ataque, Defensa);
		this.miMapa = MapaLogico.InstanciaMapaLogico ();
	}
	
	public abstract void morir() ;
	
	public Estado getEstado () {
		return miEstadoActual;
	}
	
	public int getAlcance () {
		return Alcance;
	}
	
	public void setEstado (Estado e) {
		miEstadoActual = e;
	}
}