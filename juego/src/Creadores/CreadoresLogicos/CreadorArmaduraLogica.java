package Creadores.CreadoresLogicos;

import Logica.Posicion;
import Objetos.ObjsDeLaTienda.Armadura;
import entidades.Controlable;
import entidades.ObjDeLaTienda;

public class CreadorArmaduraLogica implements FactoryLogica {
	
	private static int Costo = 400;

	public ObjDeLaTienda crearObj (Posicion pos) {
		Armadura A = new Armadura ();
		return A;
	}
	
	public Controlable crearCont (Posicion pos) {
		return null;
	}
	
	public int getCosto () {
		return Costo;
	}
}