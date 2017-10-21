package Creadores.CreadoresLogicos;

import Controlables.Elite;
import Logica.Posicion;
import entidades.Controlable;
import entidades.ObjDeLaTienda;

public class CreadorEliteLogico implements FactoryLogica {
	
	public Controlable crearCont (Posicion pos) {
		Elite E = new Elite (pos);
		return E;
	}
	
	public ObjDeLaTienda crearObj (Posicion pos) {
		return null;
	}
}
