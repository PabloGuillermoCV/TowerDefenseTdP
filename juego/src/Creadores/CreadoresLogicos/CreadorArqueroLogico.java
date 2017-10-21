package Creadores.CreadoresLogicos;

import Controlables.Arquero;
import Logica.Posicion;
import entidades.Controlable;
import entidades.ObjDeLaTienda;

public class CreadorArqueroLogico implements FactoryLogica {
	
	public Controlable crearCont (Posicion pos) {
		Arquero A = new Arquero (pos);
		return A;
	}
	
	public ObjDeLaTienda crearObj (Posicion pos) {
		return null;
	}
}