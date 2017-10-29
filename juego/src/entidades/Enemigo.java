package entidades;

import Logica.Celda;

import Logica.MapaLogico;
import Logica.Posicion;

import java.util.Random;

import Enemigos.*;
import Objetos.ObjResistente.Roca;


public abstract class Enemigo extends Personaje implements Mejorable {
	
	protected int VelocidadMov;
	protected EstrategiaDeMovimiento EstadoCaminar;
	protected int Puntaje;
	
	public Enemigo (String Nombre, Posicion Pos, int Vida, int Alcance,
		   int Ataque, int Defensa, int VelocidadMov, boolean EfectoEspecial,
		   int Puntaje) {
		super (Nombre,Pos,Vida,Alcance,Ataque,Defensa);
		this.VelocidadMov = VelocidadMov;
		this.Puntaje = Puntaje;
		this.EstadoCaminar = new CaminarNormal(this);
		this.miMapa.agregarEnemigo(this);
	}
	
	public int getVelMov () {
		return VelocidadMov;
	}
	
	public int getPuntaje () {
		return Puntaje;
	}
	
	public int calcularGolpe(Controlable C){
		return C.getEstado().getVida() - (C.getEstado().getDefensa() - miEstadoActual.getAtaque());
	}
	
	public MapaLogico getMapa () {
		return miMapa;
	}
	
	public EstrategiaDeMovimiento getEstadoCaminar () {
		return EstadoCaminar;
	}
	
	public void setEstado (EstrategiaDeMovimiento estado) {
		EstadoCaminar = estado;
	}
	
	/**
	 * metodo de visitor que permite a un enemigo ser atacado por algo que desconoce
	 * @param C Visitante a aceptar
	 */
	public void serAtacado(Controlable C) {
		C.atacar(this);
	}
	
	/**
	 * metodo de visitor que permite a un enemigo atacar a una unidad concreta
	 * @param C Controlable a atacar
	 */
	public abstract void atacar(Controlable C);
	
	/**
	 * metodo de visitor que permite a un enemigo atacar el objeto que bloquea su camino
	 * @param R Roca a atacar
	 */
	public abstract void atacar(Roca R);
	
	public boolean verficiarAliadoEnRango(Controlable C){
		boolean is = false;
		for(int X = Alcance; X > -Alcance && !is; X--) {
			for(int Y = Alcance; Y > -Alcance && !is; Y--) {
				Celda cel = miMapa.getCelda(pos.getX(),pos.getY());
				if(C != null) {
					if(cel.getPersonaje() == C) {
						is = true;
					}
				}
			}
		}
		return is;
	}
	
	public void Mover () {		
		EstadoCaminar.mover ();
	}
	
	public void morir () {
		miMapa.eliminarEnemigo (this);
		this.grafico.Morir ();
		this.miMapa = null;
		this.EstadoCaminar = null;
		this.miEstadoActual = null;
		this.pos = null;
		this.grafico = null;
	}
	
	/**
	 * metodo que se encarga de mejorar al enemigo
	 */
	public void mejorar() {
		Random r = new Random();
		int vPlus = r.nextInt(50 + 1);
		int aPlus = r.nextInt(20 + 1);
		int dPlus = r.nextInt(10 + 1);
		int velPlus = r.nextInt(5 + 1);
		miEstadoActual.setVida(miEstadoActual.getVida() + vPlus);
		miEstadoActual.setAtaque(miEstadoActual.getAtaque() + aPlus);
		miEstadoActual.setDefensa(miEstadoActual.getDefensa() + dPlus);
		VelocidadMov += velPlus;
		
		
	}
}