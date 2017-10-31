package Objetos.ObjTemporal;

import Logica.Posicion;
import entidades.EntidadesGraficas.EntidadGraficaNoEnemigo;

public class Lago extends ObjetoTemporal {

	public Lago (Posicion Pos) {
		//miContador.start(); para que empiece a contar cuanto tiempo de vida le queda, cuando el Thread llega a 60, el mismo elimina el objeto del mapa
		super ("Lago", Pos, 60);
		grafico = new EntidadGraficaNoEnemigo ("src\\Objetos\\ObjTemporal\\Sprites Temporales\\Lago.png",Pos);
	}

	//Este metodo serviria para modificar los estados de los enemigos que caminan?
	public void Afectar () {}
}