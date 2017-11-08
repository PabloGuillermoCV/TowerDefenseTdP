package Objetos.ObjTemporal;

import Enemigos.Movimiento.CaminarDañado;
import Logica.Posicion;
import entidades.Enemigo;
import entidades.EntidadesGraficas.EntidadGraficaNoEnemigo;

public class CampoDebilitador extends ObjetoTemporal {

	public CampoDebilitador (Posicion Pos) {
		//miContador.start(); //para que empiece a contar cuanto tiempo de vida le queda, cuando el Thread llega a 60, el mismo elimina el objeto del mapa
		super ("CampoDebilitador", Pos, 60);
		grafico = new EntidadGraficaNoEnemigo ("src\\Objetos\\ObjTemporal\\Sprites Temporales\\CampoDebilitador.png",Pos);
	}

	public void Afectar (Enemigo E) {
		E.setEstrategia (new CaminarDañado (E));
		auxiliar = E;
	}
}