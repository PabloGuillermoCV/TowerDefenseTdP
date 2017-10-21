package entidades;

import Logica.Posicion;
import entidades.Estados.Estado;
import entidades.Estados.EstadoNormal;

public abstract class Personaje extends Entidad {
	
	protected Estado miEstadoActual;
	protected int Alcance;
	
	public Personaje (String Nombre, Posicion Pos, int Vida, int Alcance, 
			int Ataque, int Defensa) {
		super (Nombre, Pos);
		this.Alcance = Alcance;
		this.miEstadoActual = new EstadoNormal (Vida, Ataque, Defensa);
	}
	
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