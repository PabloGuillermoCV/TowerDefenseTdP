package Creadores.CreadoresLogicos;

import Controlables.Catapulta;
import Logica.Posicion;
import entidades.Controlable;
import Objetos.ObjsDeLaTienda.ObjDeLaTienda;

public class CreadorCatapultaLogica implements FactoryLogica {
	
	private static int Costo = 500;
	
	public Controlable crearCont (Posicion pos) {
		Catapulta C = new Catapulta (pos);
		return C;
	}
	
	public ObjDeLaTienda crearObj (Posicion pos) {
		return null;
	}
	
	public int getCosto () {
		return Costo;
	}
}