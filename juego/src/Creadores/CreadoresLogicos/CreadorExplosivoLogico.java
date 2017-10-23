package Creadores.CreadoresLogicos;

import Logica.Posicion;
import Objetos.ObjsDeLaTienda.Explosivo;
import entidades.Controlable;
import entidades.ObjDeLaTienda;

public class CreadorExplosivoLogico implements FactoryLogica {

	public ObjDeLaTienda crearObj (Posicion pos) {
		Explosivo E = new Explosivo ();
		return E;
	}
	
	public Controlable crearCont (Posicion pos) {
		return null;
	}
	
	public int getCosto () {
		return 450;
	}
}