package entidades;

import Logica.Posicion;

public abstract class Controlable extends Personaje {
	
	protected int Precio;
	protected int Espacio [];
	protected int VelocidadAt;
	protected Conceptual PowerUpComprado;
	
	public Controlable (String Nombre, String Label, Posicion Pos,
			int Vida, int Alcance, PowerUpDelMapa PowerUp, int Ataque, int Defensa, int Precio,
			boolean DosEspacios, int VelocidadAt, Conceptual PowerUpComprado) {
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
		this.PowerUpComprado = PowerUpComprado;
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
	
	public Conceptual getPowerUpComprado () {
		return PowerUpComprado;
	}
	
	public void setPowerUpComprado (Conceptual PUC) {
		PowerUpComprado = PUC;
	}
	
	public int getDefensa(){
		return Defensa;
	}
	
	public void serAtacado (Controlable C) {
		//Hacer nada, NO hay fuego amigo.
	}
	
	public void serAtacado (Enemigo E) {
		this.setVida(this.Vida - (this.Defensa - E.getAtaque ()));
	}
}