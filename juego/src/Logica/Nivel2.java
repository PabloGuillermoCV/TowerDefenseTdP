package Logica;

import java.io.File;
import GUI.GUI;
import Hilos.HiloEnemigo;
import Hilos.HiloGenerarEnemigo;

public class Nivel2 extends Nivel {

	public Nivel2 (GUI gui) {
		super (gui);
		posInicialEnemies = new Posicion (0,40);
		posFinalEnemies = new Posicion (460,100);
		direccionMapa = "src\\GUI\\Sprites Mapas\\Mapa2.png";
		mapaLogico.generarCaminoA (posFinalEnemies);
		cancion = new File ("src\\Audio\\Audio.Sonidos\\Level2BGM.WAV");
		hilosMovimientos = new HiloEnemigo [7];
		
		iniciarHilos ();
		generarListaEnemigos ();
		
		hiloCreador = new HiloGenerarEnemigo (this);
		hiloCreador.start ();
	}
	
	protected void generarListaEnemigos () {
		
	}

	public void siguienteNivel () {
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