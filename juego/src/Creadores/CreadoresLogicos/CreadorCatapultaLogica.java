package Creadores.CreadoresLogicos;

import Controlables.Catapulta;
import Logica.MapaLogico;
import Logica.Posicion;
import entidades.Controlable;
import Objetos.ObjsDeLaTienda.ObjDeLaTienda;

public class CreadorCatapultaLogica implements FactoryLogica {
	
	private static int Costo = 500;
	
	public Controlable crearCont (Posicion pos) {
		Catapulta C;
		Posicion Aux = new Posicion (pos.getX () + 20, pos.getY ());
		if (MapaLogico.InstanciaMapaLogico ().puedoAgregarControlable (Aux) == true) {
			C = new Catapulta (pos);
		}
		else {
			C = null;
		}
		return C;
	}
	
	public ObjDeLaTienda crearObj (Posicion pos) {
		return null;
	}
	
	public int getCosto () {
		return Costo;
	}
}