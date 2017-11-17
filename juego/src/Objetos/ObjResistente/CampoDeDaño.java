package Objetos.ObjResistente;

import Enemigos.Movimiento.CaminarDañado;
import Logica.Posicion;
import entidades.Enemigo;
import entidades.EntidadesGraficas.EntidadGraficaNoEnemigo;

public class CampoDeDaño extends ObjetoResistente {

	public CampoDeDaño (Posicion Pos) {
		super ("CampoDeDaño", Pos, 100);
		grafico = new EntidadGraficaNoEnemigo ("src\\Objetos\\ObjResistente\\Sprites Resistentes\\CampoDeDaño.png",Pos);
	}
	
	public void Afectar (Enemigo E) {
		E.setEstrategia (new CaminarDañado (E));
		E.setAfectado(true);
	}
}