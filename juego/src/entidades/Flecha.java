package entidades;

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