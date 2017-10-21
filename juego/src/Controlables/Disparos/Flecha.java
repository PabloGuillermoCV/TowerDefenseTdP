package Controlables.Disparos;

import entidades.Proyectil;
import entidades.Enemigo;

public class Flecha extends Proyectil {

	public Flecha(){
		direccionDibujo = "Flecha.GIF";
		velocidadMovimiento = 5;
	}

	@Override
	protected void volarAEnemigo(Enemigo E) {
		// TODO Auto-generated method stub
	}
}