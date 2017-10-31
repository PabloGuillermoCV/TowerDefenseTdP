package Objetos.PowerUpsDelMapa;

import Logica.Posicion;
import entidades.Enemigo;
import entidades.EntidadesGraficas.EntidadGraficaNoEnemigo;

public class EscudoPlus extends PowerUpDelMapa {

	public EscudoPlus (Posicion Pos, Enemigo ContieneEnemigo) {
		super ("EscudoPlus", Pos, ContieneEnemigo);
		grafico = new EntidadGraficaNoEnemigo ("src\\Objetos\\PowerUpsDelMapa\\Sprites Power Ups\\EscudoPlus.png",Pos);
	}

	public void Afectar () {
		
	}
}