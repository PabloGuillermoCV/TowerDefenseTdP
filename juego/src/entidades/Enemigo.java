package entidades;

import Logica.Celda;
import Logica.MapaLogico;
import Logica.Posicion;
import java.util.Random;
import Enemigos.*;
import Enemigos.Movimiento.*;
import Objetos.ObjResistente.*;
import Objetos.ObjTemporal.*;
import Objetos.PowerUpsDelMapa.*;

public abstract class Enemigo extends Personaje implements Mejorable {
	
	protected int VelocidadMov;
	protected EstrategiaDeMovimiento EstadoCaminar;
	protected int Recompensa;
	protected int Puntaje;
	protected boolean bloqueado; //boolean para sincronizar gráfica con lógica
	
	public Enemigo (String Nombre, Posicion Pos, int Vida, int Alcance,
		   int Ataque, int Defensa, int VelocidadMov, boolean EfectoEspecial, 
		   int Recompensa, int Puntaje) {
		super (Nombre,Pos,Vida,Alcance,Ataque,Defensa);
		this.VelocidadMov = VelocidadMov;
		this.Recompensa = Recompensa;
		this.Puntaje = Puntaje;
		this.EstadoCaminar = new CaminarNormal(this);
		this.miMapa.agregarEnemigo(this);
		bloqueado = false;
	}
	
	public int getVelMov () {
		return VelocidadMov;
	}
	
	public int getRecompensa () {
		return Recompensa;
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
	
	public void setEstrategia (EstrategiaDeMovimiento estado) {
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
		if(!bloqueado && !estoyMuerto){
			EstadoCaminar.mover ();
		}
	}
	
	public void morir () {
		estoyMuerto = true;
		System.out.println("ESTOY PASANDO POR MORIR");
		Posicion aux = new Posicion (this.pos.getX (), this.pos.getY ());
		generarObjeto (aux);
		if(grafico != null)
			grafico.Morir ();
		miMapa.eliminarEnemigo (this);
		miMapa = null;
		EstadoCaminar = null;
		miEstadoActual = null;
		pos = null;
		grafico = null;
	}
	
	private void generarObjeto(Posicion aux) {
		Random Rand = new Random ();
		int I = Rand.nextInt (100) + 1; //Probabilidad de dejar caer un objeto
		
		if (I <= 20) { //20% de probabilidad de dejar caer uno
			if (I < 12) { //60% de probabilidad de que el objeto sea un power up
				I = Rand.nextInt (3) + 1; //Cual de los 3 voy a dejar
				PowerUpDelMapa PU = null;
				switch (I) {
					case 1:
						PU = new VidaPlus (aux);
						break;
					case 2:
						PU = new AtaquePlus (aux);
						break;
					case 3:
						PU = new EscudoPlus (aux);
						break;
				}
				miMapa.agregarObjeto (PU);
			}
			else { //40% de probabilidad de que el objeto sea un obstaculo
				I = Rand.nextInt (4) + 1; //Cual de los 4 voy a dejar
				Objeto O = null;
				switch (I) {
					case 1:
						O = new CampoDeDaño (aux);
						break;
					case 2:
						O = new Roca (aux);
						break;
					case 3:
						O = new CampoDebilitador (aux);
						break;
					case 4:
						O = new Lago (aux);
						break;
				}
				miMapa.agregarObjeto (O);
			}
		}
	}
	
	public void morirEnCastillo () {
		estoyMuerto = true;
		// si bien el enemigo llego a la base y no murio con esto me encargo de
		// que no haya problemas con el hilo que los mueve y el metodo mover
		miMapa.getNivel ().llegoEnemigoABase (this);
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
	public void mejorar () {
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
	
	public boolean estoyEnJuego () {
		if(grafico != null)
			return grafico.getGrafico ().isVisible () == true;
		return false;
	}
	
	public void activar () {
		grafico.getGrafico ().setVisible (true);
		grafico.desbloqueate(); //cuando aparece la gráfica, la desbloqueo para que se pueda mover
	}
	
	/**
	 * método para desbloquear el enemigo lógicamente desde la gráfica
	 */
	public void desbloqueado (){
		bloqueado = false;
	}

	public void bloqueate () {
		bloqueado = true;
	}
	
	public void meMori(){
		estoyMuerto = true;
	}
}