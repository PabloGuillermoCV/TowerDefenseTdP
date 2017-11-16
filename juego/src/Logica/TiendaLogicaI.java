package Logica;

import Creadores.CreadoresLogicos.FactoryLogica;
import GUI.TiendaVisual;
import Objetos.ObjsDeLaTienda.ObjDeLaTienda;
import entidades.Controlable;

public interface TiendaLogicaI {
	public TiendaLogica InstanciaTiendaLogica ();
	public void habilitarOleada ();
	public void setTiendaVisual (TiendaVisual TV);
	public Controlable createPersonaje (Posicion pos);
	public ObjDeLaTienda createObjeto (Posicion pos);
	public TiendaVisual getMarket ();
	
	//los 3 set Acontinuacion tienen como requerimiento recibir un entero positivo en caso de 
	//que se le sume y un entero negativo en caso de que se le reste.
	public void setMonedasJugador(int m);
	public void restablecerVidaJugador();
	public void setPuntajeJugador(int p);
	
	public void ActualizarValores ();
	
	public void setCreador (FactoryLogica f);
	public FactoryLogica getCreator () ;
	public void EliminarCreador ();
	
}
