package Hilos;

import Logica.Nivel;

public class HiloGenerarEnemigo extends Thread {
	
	protected Nivel miNivel;
	
	public HiloGenerarEnemigo (Nivel miNivel) {
		this.miNivel = miNivel;
	}
	
	public void run () {
		int Cont = 0;
		while (Cont < 3) {
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