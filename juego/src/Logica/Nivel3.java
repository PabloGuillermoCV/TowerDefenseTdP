package Logica;

import java.io.File;
import GUI.GUI;

public class Nivel3 extends Nivel {
	
	public Nivel3 (GUI gui) {
		miGui = gui;
		posInicialEnemies = new Posicion (440,300);
		posFinalEnemies = new Posicion (140,120);
		direccionMapa = "src\\GUI\\Sprites Mapas\\Mapa3.png";
		mapaLogico = MapaLogico.InstanciaMapaLogico ();
		mapaLogico.setMapaVisual (miGui.getMapaVisual());
		mapaLogico.generarCaminoA (posFinalEnemies);
		tiendaLogica = TiendaLogica.InstanciaTiendaLogica ();
		fabrica = new FabricaEnemigos ();
		cancion = new File ("src\\Audio\\Audio.Sonidos\\Level3BGM.WAV");
		
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
}