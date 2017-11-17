package Objetos.ObjTemporal;

import Logica.Posicion;
import entidades.Enemigo;
import entidades.EntidadesGraficas.EntidadGraficaNoEnemigo;
import entidades.Estados.EstadoDebil;

public class CampoDebilitador extends ObjetoTemporal {

	public CampoDebilitador (Posicion Pos) {
		super ("CampoDebilitador", Pos, 60);
		grafico = new EntidadGraficaNoEnemigo ("src\\Objetos\\ObjTemporal\\Sprites Temporales\\CampoDebilitador.png",Pos);
	}

	public void Afectar (Enemigo E) {
		int V = E.getEstado ().getVida ();
		int A = E.getEstado ().getAtaque ();
		int D = E.getEstado ().getDefensa ();
		E.setEstado (new EstadoDebil (V,A,D));
	}
}