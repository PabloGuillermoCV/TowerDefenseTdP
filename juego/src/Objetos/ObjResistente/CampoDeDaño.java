package Objetos.ObjResistente;

import Logica.Posicion;
import entidades.ObjetoResistente;
import entidades.EntidadesGraficas.EntidadGraficaNoEnemigo;

public class CampoDeDaņo extends ObjetoResistente {

	public CampoDeDaņo (Posicion Pos, int Vida) {
		super ("CampoDeDaņo", Pos, Vida);
		grafico = new EntidadGraficaNoEnemigo ("src\\GUI\\Sprites Objetos Mapa\\CampoDeDaņo.png",Pos);
	}

	public void Afectar () {
		
	}
}