package Controlables.Disparos;

import Logica.Posicion;
import entidades.Proyectil;
import entidades.EntidadesGraficas.objetoGrafico;

public class CargaCatapulta extends Proyectil {

	public CargaCatapulta () {
		velocidadMovimiento = 4;
	}

	public void setGrafico(Posicion p) {
		miGrafico = new objetoGrafico("src\\Controlables\\Disparos\\Sprites Carga Catapulta\\CargaCatapulta.png", p);
		
	}

	@Override
	public Proyectil clone() {
		Proyectil ret = new CargaCatapulta();
		ret.setGrafico(posActual);
		return ret;
	}

}