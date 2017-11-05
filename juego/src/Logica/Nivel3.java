package Logica;

import java.io.File;
import GUI.GUI;
import Hilos.HiloEnemigo;

public class Nivel3 extends Nivel {
	
	public Nivel3 (GUI gui) {
		super (gui);
		posInicialEnemies = new Posicion (440,300);
		posFinalEnemies = new Posicion (140,120);
		direccionMapa = "src\\GUI\\Sprites Mapas\\Mapa3.png";
		mapaLogico.generarCaminoA (posFinalEnemies);
		cancion = new File ("src\\Audio\\Audio.Sonidos\\Level3BGM.WAV");
		hilosMovimientos = new HiloEnemigo [7];
		
		iniciarHilos ();
		generarListaEnemigos ();
	}
	
	protected void generarListaEnemigos () {
		
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