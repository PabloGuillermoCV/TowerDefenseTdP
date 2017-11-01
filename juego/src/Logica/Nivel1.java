package Logica;

import java.io.File;

import GUI.GUI;

public class Nivel1 extends Nivel {
	
	public Nivel1 (GUI gui) {
		miGui = gui;
		posInicialEnemies = new Posicion (0,0);
		posFinalEnemies = new Posicion (480,300);
		direccionMapa = "src\\GUI\\Sprites Mapas\\Mapa1.png";
		mapaLogico = MapaLogico.InstanciaMapaLogico ();
		mapaLogico.setMapaVisual (miGui.getMapaVisual());
		mapaLogico.generarCaminoA (posFinalEnemies);
		tiendaLogica = TiendaLogica.InstanciaTiendaLogica ();
		fabrica = new FabricaEnemigos ();
		cancion = new File("src\\Audio\\Audio.Sonidos\\Level1BGM.WAV");
		
		generarListaEnemigos ();
	}
	
	public void generarListaEnemigos () {
		fabrica.crearAPie (posInicialEnemies);
		fabrica.crearACaballo (posInicialEnemies);
	}
	
	public void siguienteNivel() {
		Nivel sig = new Nivel2 (miGui);
		sig.generarListaEnemigos();
		miGui.setNivel (sig);
	}
}