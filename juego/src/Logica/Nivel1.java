package Logica;

import java.io.File;
import GUI.GUI;
import Hilos.HiloEnemigo;
import Hilos.HiloGenerarEnemigo;

public class Nivel1 extends Nivel {
	
	public Nivel1 (GUI gui) {
		super (gui);
		posInicialEnemies = new Posicion (0,0);
		posFinalEnemies = new Posicion (480,300);
		direccionMapa = "src\\GUI\\Sprites Mapas\\Mapa1.png";
		mapaLogico.generarCaminoA (posFinalEnemies);
		cancion = new File ("src\\Audio\\Audio.Sonidos\\Level1BGM.WAV");
		hilosMovimientos = new HiloEnemigo [7];
		
		iniciarHilos ();
		generarListaEnemigos ();
		
		hiloCreador = new HiloGenerarEnemigo (this);
		hiloCreador.start ();
	}
	
	public void generarListaEnemigos () {
		enemigosAMandar.add (fabrica.crearAPie (posInicialEnemies));
		enemigosAMandar.add (fabrica.crearACaballo (posInicialEnemies));
		enemigosAMandar.add (fabrica.crearACaballo (posInicialEnemies));
	}
	
	public void siguienteNivel () {
		Nivel sig = new Nivel2 (miGui);
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