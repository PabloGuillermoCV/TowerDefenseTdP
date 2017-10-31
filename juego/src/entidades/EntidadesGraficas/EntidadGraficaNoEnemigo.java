package entidades.EntidadesGraficas;

import Logica.Posicion;

public class EntidadGraficaNoEnemigo extends EntidadGrafica {
	
	public EntidadGraficaNoEnemigo (String File, Posicion pos) {
		super (File, pos);
	}

	public void moverA (Posicion pos, int vel) {}

	@Override
	public void moverA(Posicion pos, int vel, int orientacion) {}
}