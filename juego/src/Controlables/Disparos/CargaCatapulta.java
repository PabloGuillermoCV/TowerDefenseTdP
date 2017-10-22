package Controlables.Disparos;

import entidades.Proyectil;
import entidades.Controlable;
import entidades.Enemigo;
import entidades.Objeto;

public class CargaCatapulta extends Proyectil {

	public CargaCatapulta () {
		direccionDibujo = "Carga.GIF";
		velocidadMovimiento = 4;
	}

	@Override
	public void volarAEnemigo (Enemigo E) {
		// TODO Auto-generated method stub
	}

	@Override
	public void volarAAliado(Controlable C) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void volarAObjeto(Objeto O) {
		// TODO Auto-generated method stub
		
	}
}