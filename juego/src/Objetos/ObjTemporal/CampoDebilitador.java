package Objetos.ObjTemporal;

import Logica.Posicion;
import entidades.ObjetoTemporal;
import entidades.EntidadesGraficas.EntidadGraficaNoEnemigo;

public class CampoDebilitador extends ObjetoTemporal {

	public CampoDebilitador (Posicion Pos) {
		super ("CampoDebilitador", Pos, 60);
		grafico = new EntidadGraficaNoEnemigo ("src\\GUI\\Sprites Objetos Mapa\\CampoDebilitador.png",Pos);
	}

	public void Afectar () {
		
	}
}