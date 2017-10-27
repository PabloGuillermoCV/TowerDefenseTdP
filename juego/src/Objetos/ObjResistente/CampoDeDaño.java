package Objetos.ObjResistente;

import Logica.Posicion;
import entidades.ObjetoResistente;
import entidades.EntidadesGraficas.EntidadGraficaNoEnemigo;

public class CampoDeDaño extends ObjetoResistente {

	public CampoDeDaño (Posicion Pos) {
		super ("CampoDeDaño", Pos, 100);
		grafico = new EntidadGraficaNoEnemigo ("src\\GUI\\Sprites Objetos Mapa\\CampoDeDaño.png",Pos);
	}

	public void Afectar () {
		
	}
}