package entidades;

import Mapa.Posicion;

public abstract class Controlable extends personaje {
	
	protected int Precio;
	protected int Espacio [];
	protected int VelocidadAt;
	
	public Controlable (String Nombre, String Label, Posicion Pos,
			int Vida, int Alcance, PowerUpDelMapa PowerUp, int Ataque, int Defensa, int Precio,
			boolean DosEspacios, int VelocidadAt) {
		super (Nombre,Label,Pos,Vida,Alcance,PowerUp,Ataque,Defensa);
		this.Precio = Precio;
		this.Espacio = new int [2];
		Espacio [0] = 1;
		if (DosEspacios) {
			Espacio [1] = 1;
		}
		else {
			Espacio [1] = 0;
		}
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

