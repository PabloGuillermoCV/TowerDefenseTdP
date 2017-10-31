package Objetos.PowerUpsDelMapa;

import Logica.Posicion;
import entidades.Enemigo;
import entidades.EntidadesGraficas.EntidadGraficaNoEnemigo;

public class AtaquePlus extends PowerUpDelMapa {

	public AtaquePlus (Posicion Pos, Enemigo ContieneEnemigo) {
		super ("AtaquePlus", Pos, ContieneEnemigo);
		grafico = new EntidadGraficaNoEnemigo ("src\\Objetos\\PowerUpsDelMapa\\Sprites Power Ups\\AtaquePlus.png",Pos);
	}

	public void Afectar () {
		
	}
}