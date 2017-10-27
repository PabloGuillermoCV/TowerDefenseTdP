package Objetos.ObjResistente;

import Logica.Posicion;
import entidades.ObjetoResistente;
import entidades.EntidadesGraficas.EntidadGraficaNoEnemigo;

public class Roca extends ObjetoResistente {

	public Roca (Posicion Pos) {
		super ("Roca", Pos, 100);
		grafico = new EntidadGraficaNoEnemigo ("src\\GUI\\Sprites Objetos Mapa\\Roca.png",Pos);
	}

	public void setVida (int i) {
		Vida = i;
	}
	
	public void Afectar () {}
}