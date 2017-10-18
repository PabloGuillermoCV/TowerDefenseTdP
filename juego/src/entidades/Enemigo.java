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
}