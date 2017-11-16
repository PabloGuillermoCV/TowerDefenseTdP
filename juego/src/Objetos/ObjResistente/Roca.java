package Objetos.ObjResistente;

import Enemigos.Movimiento.Inmovil;
import Logica.Posicion;
import entidades.Enemigo;
import entidades.EntidadesGraficas.EntidadGraficaNoEnemigo;

public class Roca extends ObjetoResistente {

	public Roca (Posicion Pos) {
		super ("Roca", Pos, 100);
		grafico = new EntidadGraficaNoEnemigo ("src\\Objetos\\ObjResistente\\Sprites Resistentes\\Roca.png",Pos);
	}

	public void setVida (int I) {
		Vida = I;
	}
	
	public void Afectar (Enemigo P) {
		P.setEstrategia (new Inmovil ());
	}
	
	public void Morir () {
		
		this.miMapa.eliminarObjeto (this);
		this.grafico.Morir ();
		this.miMapa = null;
		this.grafico = null;
		this.pos = null;
	}
}