package Creadores.CreadoresLogicos;

import Logica.Posicion;
import Objetos.ObjsDeLaTienda.KitMedico;
import entidades.Controlable;
import entidades.ObjDeLaTienda;

public class CreadorKitMedicoLogico implements FactoryLogica {
	
	private static int Costo = 220;

	public ObjDeLaTienda crearObj (Posicion pos) {
		KitMedico KM = new KitMedico ();
		return KM;
	}
	
	public Controlable crearCont (Posicion pos) {
		return null;
	}
	
	public int getCosto () {
		return Costo;
	}
}