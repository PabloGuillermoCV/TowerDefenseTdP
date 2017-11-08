package Objetos.ObjResistente;

import Logica.Posicion;
import entidades.Enemigo;
import entidades.EntidadesGraficas.EntidadGraficaNoEnemigo;

public class CampoDeDa�o extends ObjetoResistente {

	public CampoDeDa�o (Posicion Pos) {
		super ("CampoDeDa�o", Pos, 100);
		grafico = new EntidadGraficaNoEnemigo ("src\\Objetos\\ObjResistente\\Sprites Resistentes\\CampoDeDa�o.png",Pos);
	}
	
	public void setVida (int I) {
		Vida = I;
	}
	
	public void Afectar (Enemigo P) {
		
	}
}