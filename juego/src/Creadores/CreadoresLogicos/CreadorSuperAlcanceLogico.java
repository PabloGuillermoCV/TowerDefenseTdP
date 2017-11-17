package Creadores.CreadoresLogicos;

import Logica.Posicion;
import entidades.Controlable;
import Objetos.ObjsDeLaTienda.ObjDeLaTienda;
import Objetos.ObjsDeLaTienda.SuperAlcance;

public class CreadorSuperAlcanceLogico implements FactoryLogica {
	
	private static int Costo = 450;

	public ObjDeLaTienda crearObj (Posicion pos) {
		SuperAlcance E = new SuperAlcance ();
		return E;
	}
	
	public Controlable crearCont (Posicion pos) {
		return null;
	}
	
	public int getCosto () {
		return Costo;
	}
}