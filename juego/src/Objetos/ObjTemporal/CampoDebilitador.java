package Objetos.ObjTemporal;

import Enemigos.Movimiento.CaminarDa�ado;
import Logica.Posicion;
import entidades.Enemigo;
import entidades.EntidadesGraficas.EntidadGraficaNoEnemigo;

public class CampoDebilitador extends ObjetoTemporal {

	public CampoDebilitador (Posicion Pos) {
		super ("CampoDebilitador", Pos, 60);
		grafico = new EntidadGraficaNoEnemigo ("src\\Objetos\\ObjTemporal\\Sprites Temporales\\CampoDebilitador.png",Pos);
	}

	public void Afectar (Enemigo E) {
		E.setEstrategia (new CaminarDa�ado (E));
		auxiliar = E;
	}
}