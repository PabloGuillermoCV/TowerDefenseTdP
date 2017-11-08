package Objetos.ObjResistente;

import Logica.Posicion;
import entidades.Enemigo;
import entidades.EntidadesGraficas.EntidadGraficaNoEnemigo;

public class CampoDeDaño extends ObjetoResistente {

	public CampoDeDaño (Posicion Pos) {
		super ("CampoDeDaño", Pos, 100);
		grafico = new EntidadGraficaNoEnemigo ("src\\Objetos\\ObjResistente\\Sprites Resistentes\\CampoDeDaño.png",Pos);
	}
	
	public void setVida (int I) {
		Vida = I;
	}
	
	public void Afectar (Enemigo P) {
		
	}
}