package Logica.Niveles;

import java.io.File;

import GUI.FinDelJuego;
import GUI.GUI;
import GUI.MenuPrincipal;
import Hilos.HiloGenerarEnemigo;
import Logica.Posicion;
import Logica.Caminos.Camino3;

public class Nivel3 extends Nivel {
	
	public Nivel3 (GUI gui) {
		super (gui);
		direccionMapa = "src\\GUI\\Sprites Mapas\\Mapa3.png";
		gui.setGrafico (direccionMapa);
		posInicialEnemies = new Posicion (440,300);
		posFinalEnemies = new Posicion (140,120);
		miCamino = new Camino3 ();
		miCamino.generarCamino ();
		cancion = new File ("src\\Audio\\Audio.Sonidos\\Level3BGM.WAV");
		miBGM.setAudio(cancion);
		miBGM.Activar();
		generarListaEnemigos ();
		hiloCreador = new HiloGenerarEnemigo (this);
	}
	
	public void generarListaEnemigos () {
		//Oleada 1
		enemigosAMandar.add (fabrica.crearConArmadura (posInicialEnemies));
		enemigosAMandar.add (fabrica.crearConArmadura (posInicialEnemies));
		enemigosPorOleada.add (enemigosAMandar.size ());
		
		//Oleada 2
		enemigosAMandar.add (fabrica.crearConArmadura (posInicialEnemies));
		enemigosAMandar.add (fabrica.crearConArmadura (posInicialEnemies));
		enemigosPorOleada.add (enemigosAMandar.size ());
				
		//Oleada 3
		enemigosAMandar.add (fabrica.crearJefeFinal (posInicialEnemies));
		enemigosPorOleada.add (enemigosAMandar.size ());
		
		CantidadEnemigos = enemigosAMandar.size ();
	}

	public void siguienteNivel () {
		miGui.dispose(); //ELIMINO EL FRAME PARA LIBERRAR MEMORIA
		MenuPrincipal menu = new MenuPrincipal();
	}
	
	public void reiniciar () {
		Nivel sig = new Nivel3 (miGui);
		miGui.setNivel (sig);
		miGui.reiniciarTodo ();
	}

	@Override
	public void Victoria() {
		FinDelJuego Fin = new FinDelJuego(miGui.getMapaVisual().getMapa());
		
	}
}