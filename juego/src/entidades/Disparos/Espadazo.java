package entidades.Disparos;

import Logica.Posicion;
import entidades.Proyectil;
import entidades.EntidadesGraficas.EntidadGraficaAtaque;

public class Espadazo extends Proyectil {
	
	private String [] Graficos;
	
	public Espadazo (Posicion posI, Posicion posF) {
		super (posI, posF);
		velocidadMovimiento = 10;
		Graficos = new String [8];
		Graficos [0] = "src\\GUI\\Sprites Disparos\\Sprites Espadazo\\EspadazoAbajo.png";
		Graficos [1] = "src\\GUI\\Sprites Disparos\\Sprites Espadazo\\EspadazoAbajoDerecha.png";
		Graficos [2] = "src\\GUI\\Sprites Disparos\\Sprites Espadazo\\EspadazoAbajoIzquierda.png";
		Graficos [3] = "src\\GUI\\Sprites Disparos\\Sprites Espadazo\\EspadazoArriba.png";
		Graficos [4] = "src\\GUI\\Sprites Disparos\\Sprites Espadazo\\EspadazoArribaDerecha.png";
		Graficos [5] = "src\\GUI\\Sprites Disparos\\Sprites Espadazo\\EspadazoArribaIzquierda.png";
		Graficos [6] = "src\\GUI\\Sprites Disparos\\Sprites Espadazo\\EspadazoDerecha.png";
		Graficos [7] = "src\\GUI\\Sprites Disparos\\Sprites Espadazo\\EspadazoIzquierda.png";
		miGrafico = new EntidadGraficaAtaque(Graficos, posI);
		miThread = miThread.getInstance();
		miThread.agregarProyectil(this);
	}
	
	public void setGrafico(Posicion p) {
		miGrafico = new EntidadGraficaAtaque (Graficos, p);
	}
}