package Logica;

import Creadores.Factory;
import Logica.Jugador;
import entidades.Controlable;
import entidades.entidad;

public class TiendaLogica {
	
	protected Factory creator;
	protected Jugador P; //En esta clase se encarga de verificar que las monedas sean suficientes
	
	public TiendaLogica (int w, int h) { //por ahora no hace nada con las medidas
		creator = null;
	}
	/*
	public entidad getControlable () {
		if(creator == null)
			return null;
		else {
			entidad e=  creator.crear();
			creator =null;
			return e;
		}
			
	}
	*/
	public Jugador getP () {
		return P;
	}
	
	public void setCreador (Factory f) {
		creator = f;
	}
}