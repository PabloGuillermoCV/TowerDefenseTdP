package Objetos.PowerUpsDelMapa;

import Logica.Posicion;
import entidades.Objeto;
import entidades.Personaje;
import entidades.EntidadesGraficas.EntidadGraficaNoEnemigo;
import entidades.Estados.EstadoVida;

public class VidaPlus extends PowerUpDelMapa {

	public VidaPlus (Posicion Pos) {
		super ("VidaPlus", Pos);
		grafico = new EntidadGraficaNoEnemigo ("src\\Objetos\\PowerUpsDelMapa\\Sprites Power Ups\\VidaPlus.png",Pos);
	}
	
	public void Afectar (Personaje P) {
		int V = P.getEstado ().getVida ();
		int A = P.getEstado ().getAtaque ();
		int D = P.getEstado ().getDefensa ();
		P.setEstado (new EstadoVida (V, A, D));
	}
	
	public Objeto Agarrar () {
		this.miMapa.eliminarObjeto(this);
		this.grafico.getGrafico().setVisible (false);
		
		return this;
	}
}