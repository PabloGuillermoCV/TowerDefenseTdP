package Logica;

import java.io.File;
import GUI.GUI;

public class Nivel2 extends Nivel {

	public Nivel2 (GUI gui) {
		miGui = gui;
		posInicialEnemies = new Posicion (0,40);
		posFinalEnemies = new Posicion (460,100);
		direccionMapa = "src\\GUI\\Sprites Mapas\\Mapa2.png";
		mapaLogico = MapaLogico.InstanciaMapaLogico ();
		mapaLogico.setMapaVisual (miGui.getMapaVisual());
		mapaLogico.generarCaminoA (posFinalEnemies);
		tiendaLogica = TiendaLogica.InstanciaTiendaLogica ();
		fabrica = new FabricaEnemigos ();
		cancion = new File ("src\\Audio\\Audio.Sonidos\\Level2BGM.WAV");
		
		generarListaEnemigos ();
	}
	
	protected void generarListaEnemigos () {
		
	}

	public void siguienteNivel () {
		Nivel sig = new Nivel3 (miGui);
		sig.generarListaEnemigos();
		miGui.setNivel (sig);
	}
}