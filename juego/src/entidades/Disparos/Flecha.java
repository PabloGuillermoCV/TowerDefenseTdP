package entidades.Disparos;

import Logica.Posicion;
import entidades.Proyectil;
import entidades.EntidadesGraficas.EntidadGraficaAtaque;

public class Flecha extends Proyectil {
	
	private String [] Graficos;
	
	public Flecha () {
		velocidadMovimiento = 5;
		Graficos = new String [8];
		Graficos [0] = "src\\GUI\\Sprites Disparos\\Sprites Flecha\\FlechaAbajo.png";
		Graficos [1] = "src\\GUI\\Sprites Disparos\\Sprites Flecha\\FlechaAbajoDerecha.png";
		Graficos [2] = "src\\GUI\\Sprites Disparos\\Sprites Flecha\\FlechaAbajoIzquierda.png";
		Graficos [3] = "src\\GUI\\Sprites Disparos\\Sprites Flecha\\FlechaArriba.png";
		Graficos [4] = "src\\GUI\\Sprites Disparos\\Sprites Flecha\\FlechaArribaDerecha.png";
		Graficos [5] = "src\\GUI\\Sprites Disparos\\Sprites Flecha\\FlechaArribaIzquierda.png";
		Graficos [6] = "src\\GUI\\Sprites Disparos\\Sprites Flecha\\FlechaDerecha.png";
		Graficos [7] = "src\\GUI\\Sprites Disparos\\Sprites Flecha\\FlechaIzquierda.png";
	}
	
	public void setGrafico (Posicion p) {
		miGrafico = new EntidadGraficaAtaque (Graficos, p);
	}

	public Proyectil clone (Posicion p) {
		Proyectil ret = new Flecha();
		ret.setGrafico (p);
		posActual = new Posicion(p.getX(),p.getY());
		return ret;
	}
}