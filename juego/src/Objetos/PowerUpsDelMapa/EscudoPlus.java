package Objetos.PowerUpsDelMapa;

import Logica.Posicion;
import entidades.Personaje;
import entidades.EntidadesGraficas.EntidadGraficaNoEnemigo;
import entidades.Estados.EstadoEscudo;

public class EscudoPlus extends PowerUpDelMapa {

	public EscudoPlus (Posicion Pos) {
		super ("EscudoPlus", Pos);
		grafico = new EntidadGraficaNoEnemigo ("src\\Objetos\\PowerUpsDelMapa\\Sprites Power Ups\\EscudoPlus.png",Pos);
	}
	
	public void Afectar (Personaje P) {
		int V = P.getEstado ().getVida ();
		int A = P.getEstado ().getAtaque ();
		int D = P.getEstado ().getDefensa ();
		P.setEstado (new EstadoEscudo (V, A, D));
		this.grafico.Morir ();
		this.grafico = null;
	}
}