package Logica;

import Creadores.CreadoresLogicos.FactoryLogica;
import Logica.Jugador;
import entidades.Entidad;
import GUI.TiendaVisual;

public class TiendaLogica {
	
	protected TiendaVisual market;
	protected FactoryLogica creator;
	protected Jugador P; //En esta clase se encarga de verificar que las monedas sean suficientes
	
	public TiendaLogica () {
		creator = null;
	}
	
	public Entidad createEntidad () {
		if (creator == null) {
			return null;
		}
		else {
			Entidad E =  creator.crear ();
			creator = null;
			return E;
		}
	}
	
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