package entidades;

import Logica.Posicion;
import Objetos.Roca;

import java.util.Collection;
import java.util.LinkedList;

import Controlables.*;

public abstract class Enemigo extends Personaje {
	
	protected int VelocidadMov;
	protected boolean EfectoEspecial;
	protected int Puntaje;
	
	public Enemigo (String Nombre, String Label, Posicion Pos, int Vida, int Alcance,
		   PowerUpDelMapa PowerUp, int Ataque, int Defensa, int VelocidadMov, boolean EfectoEspecial,
		   int Puntaje) {
		super (Nombre,Label,Pos,Vida,Alcance,PowerUp,Ataque,Defensa);
		this.VelocidadMov = VelocidadMov;
		this.EfectoEspecial = EfectoEspecial;
		this.Puntaje = Puntaje;
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
	
	/**
	 * metodo de visitor que permite a un enemigo ser atacado por algo que desconoce
	 * @param C Visitante a aceptar
	 */
	public abstract void serAtacado(Controlable C);
	
	/**
	 * metodo de visitor que permite a un enemigo atacar a una unidad concreata
	 * @param A Arquero a atacar
	 */
	public abstract void atacar(Arquero A);
	
	/**
	 * metodo de visitor que permite a un enemigo atacar a una unidad concreta
	 * @param C soldado a Caballo a atacar
	 */
	public abstract void atacar(Caballero C);
	
	/**
	 * metodo de visitor que permite a un enemigo atacar a una unidad concreta
	 * @param E soldado de Elite a atacar
	 */
	public abstract void atacar(Elite E);
	
	/**
	 * metodo de visitor que permite a un enemigo atacar a una unidad concreta
	 * @param S soldado a atacar
	 */
	public abstract void atacar(Soldado S);
	
	/**
	 * metodo de visitor que permite a un enemigo atacar a una unidad concreta
	 * @param soldado Catapulta a atacar
	 */
	public abstract void atacar(Catapulta C);
	
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
		try {
			if(this.pos.getX()!= pos.getX()) {
				while(this.pos.getX()!=pos.getX()) {
					this.grafico.setBounds(this.pos.getX()+VelocidadMov, this.pos.getY(),20, 20);
					this.pos.setX(this.pos.getX()+VelocidadMov);
				    Thread.sleep(100);
				}
			}
			else {
				while(this.pos.getY()!=pos.getY()) {
					this.grafico.setBounds(this.pos.getX(), this.pos.getY()+VelocidadMov,20, 20);
					this.pos.setY(this.pos.getY()+VelocidadMov);
				    Thread.sleep(100);
				}
			}		
			this.pos=pos;
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}