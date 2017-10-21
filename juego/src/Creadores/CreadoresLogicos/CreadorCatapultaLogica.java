package Creadores.CreadoresLogicos;

import Controlables.Catapulta;
import Logica.Posicion;
import entidades.Controlable;
import entidades.ObjDeLaTienda;

public class CreadorCatapultaLogica implements FactoryLogica {
	
	public Controlable crearCont (Posicion pos) {
		Catapulta C = new Catapulta (pos);
		return C;
	}
	
	public ObjDeLaTienda crearObj (Posicion pos) {
		return null;
	}
}