package Logica.Niveles;

import java.io.File;
import GUI.GUI;
import Hilos.HiloEnemigo;
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
		cancion = new File ("src\\Audio\\Audio.Sonidos\\Level2BGM.WAV");
		hilosMovimientos = new HiloEnemigo [7];
		
		iniciarHilos ();
		generarListaEnemigos ();
		
		hiloCreador = new HiloGenerarEnemigo (this);
		hiloCreador.start ();
	}
	
	public void generarListaEnemigos () {
		enemigosAMandar.add (fabrica.crearAPie (posInicialEnemies));
	}

	public void siguienteNivel () {
		Nivel sig = new Nivel3 (miGui);
		miGui.setNivel (sig);
	}
	
	private void iniciarHilos () {
		for (int I = 0; I < hilosMovimientos.length; I++) {
			hilosMovimientos [I] = new HiloEnemigo ();
			hilosMovimientos [I].start ();
		}
	}
}