package Logica.Niveles;

import java.io.File;
import GUI.GUI;
import Hilos.HiloEnemigo;
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
		hilosMovimientos = new HiloEnemigo [7];
		miBGM.setAudio(cancion); //seteo la BGM con la cancion del nivel actual
		miBGM.Activar();
		iniciarHilos ();
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
		//Final Del Juego
	}
	
	private void iniciarHilos () {
		for (int I = 0; I < hilosMovimientos.length; I++) {
			hilosMovimientos [I] = new HiloEnemigo ();
			hilosMovimientos [I].start ();
		}
	}

	@Override
	public void reiniciar() {
		miGui.setNivel(new Nivel3(miGui));
		
	}
}