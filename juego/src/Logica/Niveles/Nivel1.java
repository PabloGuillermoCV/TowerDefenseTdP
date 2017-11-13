package Logica.Niveles;

import java.io.File;

import GUI.EstadoVictoria;
import GUI.GUI;
import Hilos.HiloGenerarEnemigo;
import Logica.Posicion;
import Logica.Caminos.Camino1;

public class Nivel1 extends Nivel {
	
	public Nivel1 (GUI gui) {
		super (gui);
		direccionMapa = "src\\GUI\\Sprites Mapas\\Mapa1.png";
		gui.setGrafico (direccionMapa);
		posInicialEnemies = new Posicion (0,0);
		posFinalEnemies = new Posicion (480,300);
		miCamino = new Camino1 ();
		miCamino.generarCamino ();
		cancion = new File ("src\\Audio\\Audio.Sonidos\\Level1BGM.WAV");
		miBGM.setAudio(cancion);
		miBGM.Activar();
		generarListaEnemigos ();
		hiloCreador = new HiloGenerarEnemigo (this);
	}
	
	public void generarListaEnemigos () {
		//Oleada 1
		enemigosAMandar.add (fabrica.crearAPie (posInicialEnemies));
		enemigosAMandar.add (fabrica.crearACaballo (posInicialEnemies));
		enemigosAMandar.add (fabrica.crearACaballo (posInicialEnemies));
		enemigosPorOleada.add (enemigosAMandar.size ());
		
		//Oleada 2
		enemigosAMandar.add (fabrica.crearAPie (posInicialEnemies));
		enemigosPorOleada.add (enemigosAMandar.size ());
		
		//Oleada 3
		//enemigosAMandar.add (fabrica.crearAPie (posInicialEnemies));
		//enemigosAMandar.add (fabrica.crearACaballo (posInicialEnemies));
		//enemigosPorOleada.add (enemigosAMandar.size ());
		
		CantidadEnemigos = enemigosAMandar.size ();
	}
	
	public void siguienteNivel () {
		Nivel sig = new Nivel2 (miGui);
		miGui.setNivel (sig);
	}
	
	public void reiniciar () {
		Nivel sig = new Nivel1 (miGui);
		miGui.setNivel (sig);
		miGui.reiniciarTodo ();
	}

	@Override
	public void Victoria() {
		EstadoVictoria Victoria = new EstadoVictoria (miGui.getMapaVisual().getMapa());
		
		
	}
}