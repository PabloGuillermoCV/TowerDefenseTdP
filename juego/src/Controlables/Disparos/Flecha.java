package Controlables.Disparos;

import entidades.Proyectil;
import entidades.EntidadesGraficas.objetoGrafico;

import Logica.Posicion;

public class Flecha extends Proyectil {

	
	public Flecha(){ //constructor 
		velocidadMovimiento = 5;
	}
	
	public void setGrafico(Posicion p) {
		miGrafico =  new objetoGrafico("src\\Controlables\\Disparos\\Sprites Flecha\\Flecha.png", p);
	}
}