package Controlables.Disparos;

import entidades.Proyectil;
import Logica.Posicion;


public class CargaCatapulta extends Proyectil {

	public CargaCatapulta () {
		direccionDibujo = "Carga.GIF";
		velocidadMovimiento = 4;
	}

	@Override
	public void volarAPosicion(Posicion p) {
		// TODO Auto-generated method stub
		
	}

}