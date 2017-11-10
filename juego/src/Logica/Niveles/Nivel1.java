package Logica.Niveles;

import java.io.File;
import GUI.GUI;
import Hilos.HiloEnemigo;
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
		hilosMovimientos = new HiloEnemigo [7];
		
		iniciarHilos ();
		generarListaEnemigos ();
		
		hiloCreador = new HiloGenerarEnemigo (this);
		hiloCreador.start ();
	}
	
	public void generarListaEnemigos () {
		//Oleada 1
		enemigosAMandar.add (fabrica.crearAPie (posInicialEnemies));
		enemigosAMandar.add (fabrica.crearACaballo (posInicialEnemies));
		enemigosAMandar.add (fabrica.crearACaballo (posInicialEnemies));
		enemigosPorOleada.add (enemigosAMandar.size ());
		
		//Oleada 2
		enemigosPorOleada.add (enemigosAMandar.size ());
		
		//Oleada 3
		enemigosPorOleada.add (enemigosAMandar.size ());
		
		CantidadEnemigos = enemigosAMandar.size ();
	}
	
	public void siguienteNivel () {
		Nivel sig = new Nivel2 (miGui);
		miGui.setNivel (sig);
	}
	
	private void iniciarHilos () {
		for (int I = 0; I < hilosMovimientos.length; I++) {
			hilosMovimientos [I] = new HiloEnemigo ();
			hilosMovimientos [I].start ();
		}
	}
}