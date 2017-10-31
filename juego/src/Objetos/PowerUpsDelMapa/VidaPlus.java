package Objetos.PowerUpsDelMapa;

import Logica.Posicion;
import entidades.Enemigo;
import entidades.EntidadesGraficas.EntidadGraficaNoEnemigo;

public class VidaPlus extends PowerUpDelMapa {

	public VidaPlus (Posicion Pos, Enemigo ContieneEnemigo) {
		super ("VidaPlus", Pos, ContieneEnemigo);
		grafico = new EntidadGraficaNoEnemigo ("src\\Objetos\\PowerUpsDelMapa\\Sprites Power Ups\\VidaPlus.png",Pos);
	}

	public void Afectar () {
		
	}
}