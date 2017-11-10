package Logica.Niveles;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import Audio.Sonido;
import GUI.*;
import Logica.*;
import Logica.Caminos.Camino;
import Hilos.HiloEnemigo;
import Hilos.HiloGenerarEnemigo;
import Hilos.HiloInteraccion;
import entidades.Enemigo;

public abstract class Nivel {
	
	protected AbstractFactory fabrica;
	protected MapaLogico mapaLogico;
	protected TiendaLogica tiendaLogica;
	protected GUI miGui;
	protected Camino miCamino;
	protected Posicion posInicialEnemies;
	protected Posicion posFinalEnemies;
	protected String direccionMapa;
	protected File cancion;
	protected LinkedList <Enemigo> enemigosAMandar;
	protected int CantidadEnemigos;
	protected LinkedList <Integer> enemigosPorOleada;
	protected HiloEnemigo [] hilosMovimientos;
	protected HiloGenerarEnemigo hiloCreador;
	protected HiloInteraccion hiloAtaque;
	protected Sonido miBGM;
	protected Jugador P;
	
	public Nivel (GUI gui) {
		miGui = gui;
		mapaLogico = MapaLogico.InstanciaMapaLogico ();
		mapaLogico.setNivel (this);
		mapaLogico.setMapaVisual (miGui.getMapaVisual());
		tiendaLogica = TiendaLogica.InstanciaTiendaLogica ();
		fabrica = new FabricaEnemigos ();
		enemigosAMandar = new LinkedList <Enemigo> ();
		enemigosPorOleada = new LinkedList <Integer> ();
		hiloAtaque = new HiloInteraccion ();
		hiloAtaque.start ();
		miBGM = new Sonido();
		P = Jugador.InstanciaJugador ();
	}
	
	public void moverEnemigos () {
		Iterator <Enemigo> it = mapaLogico.getListaEnemigos ().iterator ();
		while (it.hasNext ()) {
			Enemigo e = it.next ();
			e.Mover ();
			try {
				Thread.sleep (100);
			}
			catch (InterruptedException e1) {
				e1.printStackTrace ();
			}
		}
	}
	
	public MapaLogico getMapa () {
		return mapaLogico;
	}
	
	/**
	 * Metodo que devuelve la TiendaLogica asociada
	 * @return TiendaLogica del  nivel (seria única, por eso la mandé para arriba)
	 */
	public TiendaLogica getTienda () {
		return tiendaLogica;
	}
	
	public Camino getCamino () {
		return miCamino;
	}
	
	public Posicion getPosicionInicial () {
		return posInicialEnemies;
	}
	
	public Posicion getPosicionFinal () {
		return posFinalEnemies;
	}
	
	public String getDireccionMapa () {
		return direccionMapa;
	}
	
	/**
	 * genera la lista de enemigos que van a estar en el nivel
	 */
	public abstract void generarListaEnemigos ();
	
	public int getCantidadEnemigos () {
		return CantidadEnemigos;
	}
	
	public LinkedList <Integer> getEnemigosPorOleada () {
		return enemigosPorOleada;
	}
	
	/**
	 * Metodo que modifica la ventana para pasar al siguiente Nivel
	 */
	public abstract void siguienteNivel ();
	
	public File getAudio () {
		return cancion;
	}
	
	public Jugador getP () {
		return P;
	}
	
	public LinkedList <Enemigo> getListaEnemigos () {
		return enemigosAMandar;
	}
	
	public void mandarEnemigo () {
		if (!enemigosAMandar.isEmpty ()) {
			boolean corte = false;
			for (int I = 0; I < hilosMovimientos.length && !corte; I++) {
				if (hilosMovimientos [I].estaLibre ()) {
					enemigosAMandar.getFirst ().activar ();
					hilosMovimientos [I].setEnemigo (enemigosAMandar.removeFirst ());
					corte = true;
				}
			}
		}
	}
	
	public void murioEnemigo (Enemigo e) {
		sacarDeHilo (e);
		P.setMonedas (P.getMonedas () + e.getRecompensa ());
		P.setPuntos (P.getPuntos () + e.getPuntaje());
		tiendaLogica.ActualizarValores ();
		e.morir();
	}
	
	public void llegoEnemigoABase (Enemigo e) {
		sacarDeHilo (e);
		mapaLogico.restarVida ();
		if (mapaLogico.getJugador ().getVidas () == 0) {
			
			//Aca se pondria en un panel un mensaje de game over
			
		}
	}
	
	private void sacarDeHilo (Enemigo e) {
		boolean corte = false;
		for (int I = 0; I < hilosMovimientos.length && !corte; I++) {
			if (hilosMovimientos [I].getEnemigo () == e) {
				hilosMovimientos [I].setEnemigo (null);
				corte = true;
			}
		}
	}
	
	public void comenzarOleada () {
		hiloCreador.Desbloquear ();
	}
}