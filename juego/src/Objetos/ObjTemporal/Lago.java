package Objetos.ObjTemporal;

import Enemigos.Movimiento.CaminarMermado;
import Logica.Posicion;
import entidades.Enemigo;
import entidades.EntidadesGraficas.EntidadGraficaNoEnemigo;

public class Lago extends ObjetoTemporal {

	public Lago (Posicion Pos) {
		super ("Lago", Pos, 60);
		grafico = new EntidadGraficaNoEnemigo ("src\\Objetos\\ObjTemporal\\Sprites Temporales\\Lago.png",Pos);
	}
	
	public void Afectar (Enemigo E) {
		E.setEstrategia (new CaminarMermado (E));
		E.setAfectado(true);
		auxiliar = E;
	}
}