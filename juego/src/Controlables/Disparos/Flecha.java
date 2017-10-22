package Controlables.Disparos;

import entidades.Proyectil;
import entidades.Controlable;
import entidades.Enemigo;
import entidades.Objeto;

public class Flecha extends Proyectil {

	public Flecha(){
		direccionDibujo = "Flecha.GIF";
		velocidadMovimiento = 5;
	}

	@Override
	public void volarAEnemigo(Enemigo E) {
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