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
		
	/**
	 * metedo que calcula cuanto daño hará una unidad aliada contra cierto enemigo
	 * @param e enemigo que es atacado
	 * @return daño a generar en el enemigo
	 */
	public int calcularGolpe(Enemigo e){
		return e.getVida() - (e.getDefensa() - this.Ataque);
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
	
	/**
	 * metodo que permite al controlable ser atacado por una unidad enemiga
	 * @param e visitor que efectua el ataque
	 */
	public void serAtacado(Enemigo e){
		e.atacar(this);
	}
	
	/**
	 * metodo de visitor que permite a un controlable atacar una unidad concreta
	 * @param E enemigo a atacar
	 */
	public void atacar(Enemigo E){
		E.setVida( E.getVida() - calcularGolpe(E));
	}
	
}