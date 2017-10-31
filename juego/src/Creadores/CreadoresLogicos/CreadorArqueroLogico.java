package Creadores.CreadoresLogicos;

import Controlables.Arquero;
import Logica.Posicion;
import entidades.Controlable;
import Objetos.ObjsDeLaTienda.ObjDeLaTienda;

public class CreadorArqueroLogico implements FactoryLogica {
	
	private static int Costo = 300;
	
	public Controlable crearCont (Posicion pos) {
		Arquero A = new Arquero (pos);
		return A;
	}
	
	public ObjDeLaTienda crearObj (Posicion pos) {
		return null;
	}
	
	public int getCosto () {
		return Costo;
	}
}