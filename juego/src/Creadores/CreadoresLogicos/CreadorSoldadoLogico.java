package Creadores.CreadoresLogicos;

import Controlables.Soldado;
import Logica.Posicion;
import entidades.Controlable;
import entidades.ObjDeLaTienda;

public class CreadorSoldadoLogico implements FactoryLogica {

	public Controlable crearCont (Posicion pos) {
		Soldado S = new Soldado (pos);
		return S;
	}
	
	public ObjDeLaTienda crearObj (Posicion pos) {
		return null;
	}
	
	public int getCosto () {
		return 200;
	}
}