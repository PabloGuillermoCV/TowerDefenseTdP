package Creadores.CreadoresLogicos;

import Controlables.Caballero;
import Logica.Posicion;
import entidades.Controlable;
import entidades.ObjDeLaTienda;

public class CreadorCaballeroLogico implements FactoryLogica {
	
	public Controlable crearCont (Posicion pos) {
		Caballero c = new Caballero (pos);
		return c;
	}
	
	public ObjDeLaTienda crearObj (Posicion pos) {
		return null;
	}
}