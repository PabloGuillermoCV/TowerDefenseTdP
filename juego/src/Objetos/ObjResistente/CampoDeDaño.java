package Objetos.ObjResistente;

import Logica.Posicion;
import entidades.ObjetoResistente;
import entidades.EntidadesGraficas.EntidadGraficaNoEnemigo;

public class CampoDeDaño extends ObjetoResistente {

	public CampoDeDaño (Posicion Pos, int Vida) {
		super ("CampoDeDaño", Pos, Vida);
		grafico = new EntidadGraficaNoEnemigo ("src\\GUI\\Sprites Objetos Mapa\\CampoDeDaño.png",Pos);
	}

	public void Afectar () {
		
	}
}