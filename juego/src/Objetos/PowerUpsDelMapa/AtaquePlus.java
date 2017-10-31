package Objetos.PowerUpsDelMapa;

import Logica.Posicion;
import entidades.Personaje;
import entidades.EntidadesGraficas.EntidadGraficaNoEnemigo;
import entidades.Estados.EstadoAtaque;

public class AtaquePlus extends PowerUpDelMapa {

	public AtaquePlus (Posicion Pos) {
		super ("AtaquePlus", Pos);
		grafico = new EntidadGraficaNoEnemigo ("src\\Objetos\\PowerUpsDelMapa\\Sprites Power Ups\\AtaquePlus.png",Pos);
	}

	public void Afectar (Personaje P) {
		int V = P.getEstado ().getVida ();
		int A = P.getEstado ().getAtaque ();
		int D = P.getEstado ().getDefensa ();
		P.setEstado (new EstadoAtaque (V, A, D));
		this.grafico.Morir ();
		this.grafico = null;
	}
}