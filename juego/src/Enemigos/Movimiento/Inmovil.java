package Enemigos.Movimiento;

import entidades.Enemigo;

public class Inmovil implements EstrategiaDeMovimiento {
	
	private Enemigo e;
	
	public Inmovil (Enemigo e) {
		this.e = e;
	}

	public void mover () {
		//cuanndo muere la roca, setea todas las estrategias en mover normal
		//verifico si en la pos siguiente ya no esta la roca. si no esta seteo el caminar normal
		if (!e.estoyMuerto ()) {
			
		}
	}
}