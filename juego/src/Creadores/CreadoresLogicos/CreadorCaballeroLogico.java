package Creadores.CreadoresLogicos;

import Controlables.Caballero;
import Logica.Posicion;
import entidades.Controlable;
import entidades.ObjDeLaTienda;

public class CreadorCaballeroLogico implements FactoryLogica {
	
	private static int Costo = 500;
	
	public Controlable crearCont (Posicion pos) {
		Caballero c = new Caballero (pos);
		return c;
	}
	
	public ObjDeLaTienda crearObj (Posicion pos) {
		return null;
	}
	
	public int getCosto () {
		return Costo;
	}
}