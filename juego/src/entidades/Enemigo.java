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
	protected Proyectil miBala;
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
	public void atacar(Controlable C){
		Proyectil municion = miBala.clone(pos); //esto explota para los cuerpo a cuerpo
											//a menos que agreguemos una grafica pa ellos
		municion.volarAPosicion(C.getPos());
		//calculo que por los sleep, el juego esperará hasta que la bala llegue
		//sino, lo que podemos hacer es que el proyectil sea el que le saque vida al que le pega
		//pero habria que modificar el visitor y el metodo del proyectil
		//NO tanto el visitor pero el metodo volarAPosicion deberia obtener más datos
		//(la fuerza de ataque del que dispara)
		C.getEstado().setVida(C.getEstado().getVida() - calcularGolpe(C));
		if (C.getEstado().getVida()<0) {
			C.morir();
		}
	}
	
	/**
	 * metodo de visitor que permite a un enemigo atacar el objeto que bloquea su camino
	 * @param R Roca a atacar
	 */
	public void atacar(Roca R){
		Proyectil municion = miBala.clone(pos);
		municion.volarAPosicion(R.getPos());
		R.setVida(R.getVida() - miEstadoActual.getAtaque()); 
	}
	
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