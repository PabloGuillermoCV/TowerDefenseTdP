package entidades;

import javax.swing.JLabel;
import Mapa.Posicion;

public abstract class Controlable extends personaje {
	
	protected int Precio;
	protected int Espacio [];
	protected int VelocidadAt;
	
	public Controlable (String Nombre, JLabel Label, Posicion Pos,
			int Vida, int Alcance, PowerUpDelMapa PowerUp, int Ataque, int Defensa, int Precio,
			int Espacio [], int VelocidadAt) {
		super (Nombre,Label,Pos,Vida,Alcance,PowerUp,Ataque,Defensa);
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
	
	public void serAtacado (Controlable C) {
		//Hacer nada, NO hay fuego amigo.
	}
	
	public void serAtacado (enemigo E) {
		this.setVida(this.Vida - (this.Defensa - E.getAtaque ()));
	}
}