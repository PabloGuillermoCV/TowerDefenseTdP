package entidades;

import Logica.Celda;

import Logica.MapaLogico;
import Logica.Posicion;
import Enemigos.*;
import Objetos.ObjResistente.Roca;


public abstract class Enemigo extends Personaje {
	
	protected int VelocidadMov;
	protected EstrategiaDeMovimiento EstadoCaminar;
	protected int Puntaje;
	protected MapaLogico miMapa;
	
	public Enemigo (String Nombre, Posicion Pos, int Vida, int Alcance,
		   int Ataque, int Defensa, int VelocidadMov, boolean EfectoEspecial,
		   int Puntaje) {
		super (Nombre,Pos,Vida,Alcance,Ataque,Defensa);
		this.VelocidadMov = VelocidadMov;
		this.Puntaje = Puntaje;
		this.EstadoCaminar = new CaminarNormal(this);
		miMapa = MapaLogico.InstanciaMapaLogico ();
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
	public void serAtacado(Controlable C){
		C.atacar(this);
	}
	
	/**
	 * metodo de visitor que permite a un enemigo atacar a una unidad concreata
	 * @param C Controlable a atacar
	 */
	public void atacar(Controlable C){
		C.getEstado().setVida(C.getEstado().getVida() - calcularGolpe(C));
	}
	
	/**
	 * metodo de visitor que permite a un enemigo atacar el objeto que bloquea su camino
	 * @param R Roca a atacar
	 */
	public void atacar(Roca R){
		R.setVida(R.getVida() - miEstadoActual.getAtaque()); 
	}
	
	public boolean verficiarAliadoEnRango(Controlable C){
		boolean is = false;
		for(int X = Alcance; X > -Alcance && !is; X--) {
			for(int Y = Alcance; Y > -Alcance && !is; Y--) {
				Celda cel = miMapa.getCelda(pos.getX()*20,pos.getY()*20);
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
		
		EstadoCaminar.mover();
	}
}