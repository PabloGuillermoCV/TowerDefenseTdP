package Logica;

import Creadores.CreadoresLogicos.FactoryLogica;
import Logica.Jugador;
import entidades.Controlable;
import GUI.TiendaVisual;

public class TiendaLogica {
	
	private static TiendaLogica Instancia;
	protected TiendaVisual market;
	protected FactoryLogica creator;
	protected Jugador P; //En esta clase se encarga de verificar que las monedas sean suficientes
	
	private TiendaLogica () {
		creator = null;
		P = new Jugador();
	}
	
	public static TiendaLogica InstanciaTiendaLogica () {
		if (Instancia == null) {
			Instancia = new TiendaLogica ();
		}
		return Instancia;
	}
	
	public Controlable createEntidad () {
		if (creator == null) {
			return null;
		}
		else {
			Controlable E =  creator.crear ();
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
	
	/**
	 * metodo que devuelve el Factory asociado a la Tienda en un determinado momento (Lo usaria MapaLogico)
	 * @return FactoryLogica al momento de la consulta
	 */
	public FactoryLogica getCreator(){
		
		return creator;
	}
}