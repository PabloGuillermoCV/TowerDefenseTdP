package entidades;

<<<<<<< HEAD
public abstract class Controlable extends personaje{

	public void serAtacado(Controlable a){
		//Hace nada, NO hay fuego amigo
	}
	
	public void serAtacado(enemigo e){
		this.setVida(this.vida -  (this.defensa - e.getAtaque()) );
	}
}
=======
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
>>>>>>> e8b91c34bc6416b919ae85cd6a0df95cdd345ad1
