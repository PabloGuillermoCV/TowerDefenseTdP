package Logica.Niveles;

import java.io.File;
import GUI.GUI;
import Hilos.HiloEnemigo;
import Hilos.HiloGenerarEnemigo;
import Logica.Posicion;

public class Nivel3 extends Nivel {
	
	public Nivel3 (GUI gui) {
		super (gui);
		direccionMapa = "src\\GUI\\Sprites Mapas\\Mapa3.png";
		gui.setGrafico (direccionMapa);
		posInicialEnemies = new Posicion (440,300);
		posFinalEnemies = new Posicion (140,120);
		mapaLogico.generarCaminoA (posFinalEnemies);
		cancion = new File ("src\\Audio\\Audio.Sonidos\\Level3BGM.WAV");
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
		//Final Del Juego
		Nivel sig = new Nivel3 (miGui);
		sig.generarListaEnemigos();
		miGui.setNivel (sig);
	}
	
	private void iniciarHilos () {
		for (int I = 0; I < hilosMovimientos.length; I++) {
			hilosMovimientos [I] = new HiloEnemigo ();
			hilosMovimientos [I].start ();
		}
	}
}