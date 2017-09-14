package entidades;

import javax.swing.JLabel;
import Mapa.Posicion;

<<<<<<< HEAD
	public void serAtacado(Controlable a){
		this.setVida(this.vida -  (this.defensa - a.getAtaque()) );
	}
	
	public  void serAtacado(enemigo e){}
}
=======
public abstract class enemigo extends personaje {
	
	protected int VelocidadMov;
	protected boolean EfectoEspecial;
	
	public enemigo (String Nombre, JLabel Label, Posicion Pos, int Vida, int Alcance,
			PowerUpDelMapa PowerUp, int Ataque, int Defensa, int VelocidadMov,boolean EfectoEspecial) {
		super (Nombre,Label,Pos,Vida,Alcance,PowerUp,Ataque,Defensa);
		this.VelocidadMov = VelocidadMov;
		this.EfectoEspecial = EfectoEspecial;
	}
	
	public int getVelMov () {
		return VelocidadMov;
	}
	
	public boolean getEfecto () {
		return EfectoEspecial;
	}
	
	public void serAtacado (enemigo e) {
		
	}
}
>>>>>>> e8b91c34bc6416b919ae85cd6a0df95cdd345ad1
