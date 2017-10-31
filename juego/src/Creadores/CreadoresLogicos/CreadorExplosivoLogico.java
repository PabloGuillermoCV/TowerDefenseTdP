package Creadores.CreadoresLogicos;

import Logica.Posicion;
import Objetos.ObjsDeLaTienda.Explosivo;
import entidades.Controlable;
import Objetos.ObjsDeLaTienda.ObjDeLaTienda;

public class CreadorExplosivoLogico implements FactoryLogica {
	
	private static int Costo = 450;

	public ObjDeLaTienda crearObj (Posicion pos) {
		Explosivo E = new Explosivo ();
		return E;
	}
	
	public Controlable crearCont (Posicion pos) {
		return null;
	}
	
	public int getCosto () {
		return Costo;
	}
}