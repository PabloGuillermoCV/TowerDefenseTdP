package Logica;

import Creadores.CreadoresLogicos.FactoryLogica;
import Logica.Jugador;
import entidades.Controlable;
import entidades.entidad;
import GUI.TiendaVisual;

@SuppressWarnings("unused")
public class TiendaLogica {
	
	protected TiendaVisual market;
	protected FactoryLogica creator;
	protected Jugador P; //En esta clase se encarga de verificar que las monedas sean suficientes
	
	public TiendaLogica (int w, int h) { //por ahora no hace nada con las medidas
		creator = null;
	}
	
	/*
	public entidad getControlable () {
		if(creator == null)
			return null;
		else {
			entidad e =  creator.crear ();
			creator = null;
			return e;
		}
			
	}
	*/
	
	public TiendaVisual getMarket () {
		return market;
	}
	
	public Jugador getP () {
		return P;
	}
	
	public void setCreador (FactoryLogica f) {
		creator = f;
	}
}