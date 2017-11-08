package entidades.Disparos;

import Logica.Posicion;
import entidades.Proyectil;
import entidades.EntidadesGraficas.EntidadGraficaAtaque;

public class CargaCatapulta extends Proyectil {
	
	private String [] Graficos;

	@SuppressWarnings("static-access")
	public CargaCatapulta (Posicion posI, Posicion posF) {
		super (posI,posF);
		velocidadMovimiento = 10;
		Graficos = new String [8];
		Graficos [0] = "src\\entidades\\Disparos\\Sprites Disparos\\Sprites Carga Catapulta\\CargaCatapultaAbajo.png";
		Graficos [1] = "src\\entidades\\Disparos\\Sprites Disparos\\Sprites Carga Catapulta\\CargaCatapultaAbajoDerecha.png";
		Graficos [2] = "src\\entidades\\Disparos\\Sprites Disparos\\Sprites Carga Catapulta\\CargaCatapultaAbajoIzquierda.png";
		Graficos [3] = "src\\entidades\\Disparos\\Sprites Disparos\\Sprites Carga Catapulta\\CargaCatapultaArriba.png";
		Graficos [4] = "src\\entidades\\Disparos\\Sprites Disparos\\Sprites Carga Catapulta\\CargaCatapultaArribaDerecha.png";
		Graficos [5] = "src\\entidades\\Disparos\\Sprites Disparos\\Sprites Carga Catapulta\\CargaCatapultaArribaIzquierda.png";
		Graficos [6] = "src\\entidades\\Disparos\\Sprites Disparos\\Sprites Carga Catapulta\\CargaCatapultaDerecha.png";
		Graficos [7] = "src\\entidades\\Disparos\\Sprites Disparos\\Sprites Carga Catapulta\\CargaCatapultaIzquierda.png";
		miGrafico = new EntidadGraficaAtaque(Graficos, posI, this);
		miThread = miThread.InstanciaHiloVueloProyectiles ();
		miThread.agregarProyectil(this);
	}

	public void setGrafico (Posicion p) {
		miGrafico = new EntidadGraficaAtaque (Graficos, p, this);
	}
}