package Controlables.Disparos;

import Logica.Posicion;
import entidades.Proyectil;
import entidades.EntidadesGraficas.EntidadGraficaAtaque;

public class CargaCatapulta extends Proyectil {
	
	private String [] Graficos;

	public CargaCatapulta () {
		velocidadMovimiento = 4;
		Graficos = new String [8];
		Graficos [0] = "src\\Controlables\\Disparos\\Sprites Carga Catapulta\\CargaCatapultaAbajo.png";
		Graficos [1] = "src\\Controlables\\Disparos\\Sprites Carga Catapulta\\CargaCatapultaAbajoDerecha.png";
		Graficos [2] = "src\\Controlables\\Disparos\\Sprites Carga Catapulta\\CargaCatapultaAbajoIzquierda.png";
		Graficos [3] = "src\\Controlables\\Disparos\\Sprites Carga Catapulta\\CargaCatapultaArriba.png";
		Graficos [4] = "src\\Controlables\\Disparos\\Sprites Carga Catapulta\\CargaCatapultaArribaDerecha.png";
		Graficos [5] = "src\\Controlables\\Disparos\\Sprites Carga Catapulta\\CargaCatapultaArribaIzquierda.png";
		Graficos [6] = "src\\Controlables\\Disparos\\Sprites Carga Catapulta\\CargaCatapultaDerecha.png";
		Graficos [7] = "src\\Controlables\\Disparos\\Sprites Carga Catapulta\\CargaCatapultaIzquierda.png";
	}

	public void setGrafico (Posicion p) {
		miGrafico = new EntidadGraficaAtaque (Graficos, p);
	}

	public Proyectil clone (Posicion p) {
		Proyectil ret = new CargaCatapulta();
		ret.setGrafico(p);
		posActual = new Posicion(p.getX(),p.getY());
		return ret;
	}
}