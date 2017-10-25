package Controlables.Disparos;

import entidades.Proyectil;
import entidades.EntidadesGraficas.objetoGrafico;

import Logica.Posicion;

public class Flecha extends Proyectil {

	
	public Flecha(){ //constructor 
		velocidadMovimiento = 5;
	}
	
	@Override
	public void setGrafico(Posicion p) {
		miGrafico =  new objetoGrafico("Flecha.GIF", p);
	}
}