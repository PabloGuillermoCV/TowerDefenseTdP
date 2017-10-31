package Creadores.CreadoresLogicos;

import Controlables.Elite;
import Logica.Posicion;
import entidades.Controlable;
import Objetos.ObjsDeLaTienda.ObjDeLaTienda;

public class CreadorEliteLogico implements FactoryLogica {
	
	private static int Costo = 650;
	
	public Controlable crearCont (Posicion pos) {
		Elite E = new Elite (pos);
		return E;
	}
	
	public ObjDeLaTienda crearObj (Posicion pos) {
		return null;
	}
	
	public int getCosto () {
		return Costo;
	}
}
