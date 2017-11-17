package Objetos.ObjResistente;

import Enemigos.Movimiento.Inmovil;
import Logica.Posicion;
import entidades.Enemigo;
import entidades.EntidadesGraficas.EntidadGraficaNoEnemigo;

public class Roca extends ObjetoResistente {

	public Roca (Posicion Pos) {
		super ("Roca", Pos, 500);
		grafico = new EntidadGraficaNoEnemigo ("src\\Objetos\\ObjResistente\\Sprites Resistentes\\Roca.png",Pos);
	}

	public void setVida (int I) {
		Vida = I;
	}
	
	public void Afectar (Enemigo E) {
		E.setEstrategia (new Inmovil (E));
		E.setAfectado(true);
		E.atacar(this);
	}
}