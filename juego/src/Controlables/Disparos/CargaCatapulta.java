package Controlables.Disparos;

import entidades.Proyectil;
import entidades.Enemigo;

public class CargaCatapulta extends Proyectil {

	public CargaCatapulta () {
		direccionDibujo = "Carga.GIF";
		velocidadMovimiento = 4;
	}

	@Override
	protected void volarAEnemigo (Enemigo E) {
		// TODO Auto-generated method stub
	}
}