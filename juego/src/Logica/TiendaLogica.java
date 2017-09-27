package Logica;

import Creadores.Factory;
import Logica.Jugador;

public class TiendaLogica {
	
	protected Factory creator;
	protected Jugador P; //En esta clase se encarga de verificar que las monedas sean suficientes
	
	public TiendaLogica (int w, int h) { //por ahora no hace nada con las medidas
		creator = null;
	}
	
	public Factory getCreador () {
		return creator;
	}
	
	public Jugador getP () {
		return P;
	}
	
	public void setCreador (Factory f) {
		creator = f;
	}
}