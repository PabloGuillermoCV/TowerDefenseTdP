package entidades.Disparos;

import Logica.Posicion;
import entidades.Proyectil;
import entidades.EntidadesGraficas.EntidadGraficaAtaque;

public class Flecha extends Proyectil {
	
	private String [] Graficos;
	
	@SuppressWarnings("static-access")
	public Flecha (Posicion posI, Posicion posF) {
		super (posI, posF);
		velocidadMovimiento = 10;
		Graficos = new String [8];
		Graficos [0] = "src\\entidades\\Disparos\\Sprites Disparos\\Sprites Flecha\\FlechaAbajo.png";
		Graficos [1] = "src\\entidades\\Disparos\\Sprites Disparos\\Sprites Flecha\\FlechaAbajoDerecha.png";
		Graficos [2] = "src\\entidades\\Disparos\\Sprites Disparos\\Sprites Flecha\\FlechaAbajoIzquierda.png";
		Graficos [3] = "src\\entidades\\Disparos\\Sprites Disparos\\Sprites Flecha\\FlechaArriba.png";
		Graficos [4] = "src\\entidades\\Disparos\\Sprites Disparos\\Sprites Flecha\\FlechaArribaDerecha.png";
		Graficos [5] = "src\\entidades\\Disparos\\Sprites Disparos\\Sprites Flecha\\FlechaArribaIzquierda.png";
		Graficos [6] = "src\\entidades\\Disparos\\Sprites Disparos\\Sprites Flecha\\FlechaDerecha.png";
		Graficos [7] = "src\\entidades\\Disparos\\Sprites Disparos\\Sprites Flecha\\FlechaIzquierda.png";
		miGrafico = new EntidadGraficaAtaque(Graficos, posI, this);
		miThread = miThread.InstanciaHiloVueloProyectiles ();
		miThread.agregarProyectil(this);
	}
	
	public void setGrafico (Posicion p) {
		miGrafico = new EntidadGraficaAtaque (Graficos, p, this);
	}
}