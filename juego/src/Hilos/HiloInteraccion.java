package Hilos;

import Logica.MapaLogico;

public class HiloInteraccion extends Thread {
	
	protected MapaLogico miMapa;
	
	public HiloInteraccion () {
		miMapa = MapaLogico.InstanciaMapaLogico ();
	}
	
	public void run () {
		while (true) {
			miMapa.interaccionControlableEnemigo ();
			try {
				Thread.sleep (1000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}