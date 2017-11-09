package Hilos;

import Logica.Niveles.Nivel;

public class HiloGenerarEnemigo extends Thread {
	
	protected Nivel miNivel;
	
	public HiloGenerarEnemigo (Nivel miNivel) {
		this.miNivel = miNivel;
	}
	
	public void run () {
		int Cont = 0;
		while (Cont < this.miNivel.getCantidadEnemigos ()) {
			miNivel.mandarEnemigo ();
			Cont++;
			try {
				Thread.sleep (3000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}