package Objetos.ObjTemporal;

import Logica.Posicion;
import entidades.ObjetoTemporal;
import entidades.EntidadesGraficas.EntidadGraficaNoEnemigo;

public class Lago extends ObjetoTemporal {

	public Lago (Posicion Pos, int Tiempo) {
		super ("Lago", Pos, Tiempo);
		grafico = new EntidadGraficaNoEnemigo ("src\\GUI\\Sprites Objetos Mapa\\Lago.png",Pos);
	}

	public void Afectar () {
		
	}
}