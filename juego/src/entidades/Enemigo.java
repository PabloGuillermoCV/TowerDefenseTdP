package entidades;

import Logica.Posicion;
import Enemigos.*;
import Objetos.Roca;

import java.util.Collection;
import java.util.LinkedList;

import javax.swing.JLabel;


public abstract class Enemigo extends Personaje{
	
	protected int VelocidadMov;
	protected boolean EfectoEspecial;
	protected EstadoDeMovimiento EstadoCaminar;
	protected int Puntaje;
	
	public Enemigo (String Nombre, String Label, Posicion Pos, int Vida, int Alcance,
		   PowerUpDelMapa PowerUp, int Ataque, int Defensa, int VelocidadMov, boolean EfectoEspecial,
		   int Puntaje) {
		super (Nombre,Label,Pos,Vida,Alcance,PowerUp,Ataque,Defensa);
		this.VelocidadMov = VelocidadMov;
		this.EfectoEspecial = false;
		this.Puntaje = Puntaje;
		this.EstadoCaminar = new CaminarNormal(this);
	}
	
	public int getVelMov () {
		return VelocidadMov;
	}
	
	public boolean getEfecto () {
		return EfectoEspecial;
	}
	
	public int getPuntaje () {
		return Puntaje;
	}
	
	public int calcularGolpe(Controlable C){
		return C.getVida() - (C.getDefensa() - this.Ataque);
	}
	public Posicion getPos() {
		return pos;
	}
	
	public JLabel getGrafico() {
		return grafico;
	}
	
	/**
	 * metodo de visitor que permite a un enemigo ser atacado por algo que desconoce
	 * @param C Visitante a aceptar
	 */
	public abstract void serAtacado(Controlable C);
	
	/**
	 * metodo de visitor que permite a un enemigo atacar a una unidad concreata
	 * @param C Controlable a atacar
	 */
	public abstract void atacar(Controlable C);
	
	
	/**
	 * metodo de visitor que permite a un enemigo atacar el objeto que bloquea su camino
	 * @param R Roca a atacar
	 */
	public abstract void atacar(Roca R);
	
	public Collection<Posicion> verficiarAliadosEnRango(){
		Collection<Posicion> PosicionesaAtacar = new LinkedList<Posicion>();
		
		return PosicionesaAtacar;
		
	}
	
	public void MoverA (Posicion pos) {
		EstadoCaminar.moverA(pos);
	}

	/**
	 * Metodo que verifica si el enemigo esta en rango como para atacar a la unidad Aliada que lo atacó
	 * @param e Aliado a buscar por el rango
	 * @return si el Aliado es atacable
	 */
	public boolean estaEnRango(Controlable e) {
		boolean ret = false;
		/*NOTA: estoy teniendo un problema en COMO recorrer el rango efectivo de la unidad
		 * calculo que se deberia hacer con un for doble anidado para que recorra primero el eje X y despues el Eje Y, 
		 * pero el drama viene que tendria que hacer DOS for dobles anidados, uno que verifique la parte de X y otro que verifique la parte de Y
		 * para esto, subiré una foto de un dibujo que hice para que se entienda el problema, veanlo en el Drive
		 * aunque este apenas encuentro a la unidad que busco deberia cortar
		*/
		return ret;
	}
}