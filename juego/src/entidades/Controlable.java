package entidades;

import Logica.Posicion;
import Enemigos.*;

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
	public abstract void serAtacado(Enemigo e);
	
	/**
	 * metodo de visitor que permite a un controlable atacar una unidad concreta
	 * @param AC enemigo a Caballo a atacar
	 */
	public abstract void atacar(ACaballo AC);
	
	/**
	 * metodo de visitor que permite a un controlable atacar a una unidad concreta
	 * @param AP enemigo a Pie a atacar
	 */
	public abstract void atacar(APie AP);
	
	/**
	 * metodo de visitor que permite a un controlable atacar a una unidad concreta
	 * @param AC enemigo Con Arco a atacar
	 */
	public abstract void atacar(ConArco AC);
	
	/**
	 * metodo de visitor que permite a un controlable atacar a una unidad concreta
	 * @param CA enemigo Con Armadura a atacar
	 */
	public abstract void atacar(ConArmadura CA);
	
	/**
	 * metodo de visitor que permite a un controlable atacar a una unidad concreta
	 * @param CB enemigo con Ballesta a atacar
	 */
	public abstract void atacar(ConBallesta CB);
	
	/**
	 * metodo de visitor que permite a un controlable atacar a una unidad concreta
	 * @param JF Jefe Final a atacar (Este método deberia ser el que dispara las transiciones especiales)
	 */
	public abstract void atacar(JefeFinal JF);
}