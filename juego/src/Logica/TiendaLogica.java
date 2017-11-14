package Logica;

import Creadores.CreadoresLogicos.FactoryLogica;
import Logica.Jugador;
import entidades.Controlable;
import Objetos.ObjsDeLaTienda.ObjDeLaTienda;
import GUI.TiendaVisual;

public class TiendaLogica {
	
	private static TiendaLogica Instancia;
	protected TiendaVisual market;
	protected FactoryLogica creator;
	protected Jugador P; //En esta clase se encarga de verificar que las monedas sean suficientes
	
	private TiendaLogica () {
		creator = null;
		P = Jugador.InstanciaJugador ();
	}
	
	public static TiendaLogica InstanciaTiendaLogica () {
		if (Instancia == null) {
			Instancia = new TiendaLogica ();
		}
		return Instancia;
	}
	
	public void habilitarOleada () {
		this.market.setBotonOleadaOn ();
	}
	
	public void setTiendaVisual (TiendaVisual TV) {
		market = TV;
	}
	
	public Controlable createPersonaje (Posicion pos) {
		if (creator == null) {
			return null;
		}
		else {
			Controlable E = creator.crearCont (pos);
			//creator = null;
			return E;
		}
	}
	
	public ObjDeLaTienda createObjeto (Posicion pos) {
		if (creator == null) {
			return null;
		}
		else {
			ObjDeLaTienda O = creator.crearObj (pos);
			creator = null;
			return O;
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
	public FactoryLogica getCreator () {
		return creator;
	}
	
	public void EliminarCreador () {
		creator = null;
	}
	
	/**
	 * método que se encarga de actualizar las monedas y el puntaje
	 */
	public void ActualizarValores () {
		market.modificarMonedas ();
		market.modificarPuntaje ();
	}
}