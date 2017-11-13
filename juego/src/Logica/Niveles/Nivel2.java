package Logica.Niveles;

import java.io.File;

import GUI.EstadoVictoria;
import GUI.GUI;
import Hilos.HiloGenerarEnemigo;
import Logica.Posicion;
import Logica.Caminos.Camino2;

public class Nivel2 extends Nivel {

	public Nivel2 (GUI gui) {
		super (gui);
		direccionMapa = "src\\GUI\\Sprites Mapas\\Mapa2.png";
		gui.setGrafico (direccionMapa);
		posInicialEnemies = new Posicion (0,40);
		posFinalEnemies = new Posicion (460,100);
		miCamino = new Camino2 ();
		miCamino.generarCamino ();
		generarListaEnemigos ();
		cancion = new File ("src\\Audio\\Audio.Sonidos\\Level2BGM.WAV");
		miBGM.setAudio(cancion);
		miBGM.Activar();
		hiloCreador = new HiloGenerarEnemigo (this);
	}
	
	public void generarListaEnemigos () {
		//Oleada 1
		enemigosAMandar.add (fabrica.crearAPie (posInicialEnemies));
		enemigosPorOleada.add (enemigosAMandar.size ());
		
		//Oleada 2
		//enemigosAMandar.add (fabrica.crearConArco (posInicialEnemies));
		//enemigosPorOleada.add (enemigosAMandar.size ());
		
		//Oleada 3
		//enemigosAMandar.add (fabrica.crearConArco (posInicialEnemies));
		//enemigosAMandar.add (fabrica.crearConBallesta (posInicialEnemies));
		//enemigosPorOleada.add (enemigosAMandar.size ());
		
		CantidadEnemigos = enemigosAMandar.size ();
	}

	public void siguienteNivel () {
		Nivel sig = new Nivel3 (miGui);
		miGui.setNivel (sig);
	}
	
	public void reiniciar () {
		Nivel sig = new Nivel2 (miGui);
		miGui.setNivel (sig);
		miGui.reiniciarTodo ();
	}

	@Override
	public void Victoria() {
		EstadoVictoria Victoria = new EstadoVictoria (miGui.getMapaVisual().getMapa());
		
	}
}