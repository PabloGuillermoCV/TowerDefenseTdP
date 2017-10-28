package Controlables.Disparos;

import Logica.Posicion;
import entidades.Proyectil;
import entidades.EntidadesGraficas.objetoGrafico;

public class Espadazo extends Proyectil{
	
	public Espadazo(){
		velocidadMovimiento = 10;
	}
	

	@Override
	public void setGrafico(Posicion p) { //Necesito el grafico del espadazo en sus 8 variaciones
		miGrafico = new objetoGrafico("src\\Controlables\\Disparos\\Sprites Espada\\Espadazo.GIF", p);
		
	}

	@Override
	public Proyectil clone() {
		Proyectil ret = new Espadazo();
		ret.setGrafico(posActual);
		return ret;
	}

}
