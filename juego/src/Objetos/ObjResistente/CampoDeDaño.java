package Objetos.ObjResistente;

import Logica.Posicion;
import entidades.ObjetoResistente;
import entidades.EntidadesGraficas.EntidadGraficaNoEnemigo;

public class CampoDeDa�o extends ObjetoResistente {

	public CampoDeDa�o (Posicion Pos, int Vida) {
		super ("CampoDeDa�o", Pos, Vida);
		grafico = new EntidadGraficaNoEnemigo ("src\\GUI\\Sprites Objetos Mapa\\CampoDeDa�o.png",Pos);
	}

	public void Afectar () {
		
	}
}