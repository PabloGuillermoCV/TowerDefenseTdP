package Objetos.ObjTemporal;

import Hilos.HiloReducirDa�o;
import Logica.Posicion;
import entidades.Enemigo;
import entidades.EntidadesGraficas.EntidadGraficaNoEnemigo;

public class CampoDebilitador extends ObjetoTemporal {
	
	private HiloReducirDa�o miHilo;

	public CampoDebilitador (Posicion Pos) {
		super ("CampoDebilitador", Pos, 60);
		grafico = new EntidadGraficaNoEnemigo ("src\\Objetos\\ObjTemporal\\Sprites Temporales\\CampoDebilitador.png",Pos);
	}

	public void Afectar (Enemigo E) {
		miHilo = new HiloReducirDa�o (E);
		miHilo.run ();
	}
}