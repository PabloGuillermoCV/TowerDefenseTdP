package Logica;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import GUI.*;
import Hilos.HiloEnemigo;
import Hilos.HiloGenerarEnemigo;
import entidades.Controlable;
import entidades.Enemigo;

public abstract class Nivel {
	
	protected AbstractFactory fabrica;
	protected MapaLogico mapaLogico;
	protected TiendaLogica tiendaLogica;
	protected GUI miGui;
	protected Posicion posInicialEnemies;
	protected Posicion posFinalEnemies;
	protected String direccionMapa;
	protected File cancion;
	protected HiloEnemigo [] hilosMovimientos;
	protected LinkedList <Enemigo> enemigosAMandar;
	protected HiloGenerarEnemigo hiloCreador;
	
	public Nivel (GUI gui) {
		miGui = gui;
		mapaLogico = MapaLogico.InstanciaMapaLogico ();
		mapaLogico.setMapaVisual (miGui.getMapaVisual());
		tiendaLogica = TiendaLogica.InstanciaTiendaLogica ();
		fabrica = new FabricaEnemigos ();
		enemigosAMandar = new LinkedList <Enemigo> ();
	}
	
	/**
	 * realiza la interaccion entre controlables y enemigos
	 */
	public void InteraccionControlableEnemigo () {
		Enemigo e;
		for (Controlable C : mapaLogico.getListaControlables ()) {
			System.out.println ("ESTOY EN INTERACCION-----------------------");
			e = C.verificarUnidad();
			if (e != null && e.estoyEnJuego ()) {
				e.serAtacado(C);
			}
		}
	}
	
	public void moverEnemigos () {
		Iterator <Enemigo> it = mapaLogico.getListaEnemigos ().iterator ();
		while (it.hasNext ()) {
			Enemigo e = it.next ();
			e.Mover ();
			try {
				Thread.sleep (100);
				//si mi teoria es correcta, esto haria que las unidades se 
				//muevan con cierta distancia entre ellas.
				//Mi teoria era 75% correcta, genera una separación, pero despues se vuelven a juntar
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
	protected abstract void generarListaEnemigos ();
	
	/**
	 * Metodo que modifica la ventana para pasar al siguiente Nivel
	 */
	public abstract void siguienteNivel ();
	
	public File getAudio(){
		return cancion;
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
}