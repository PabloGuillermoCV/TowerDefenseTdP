package Hilos;

import java.util.Iterator;
import Logica.Niveles.Nivel;

public class HiloGenerarEnemigo extends Thread {
	
	protected Nivel miNivel;
	protected boolean Bloqueo;
	
	public HiloGenerarEnemigo (Nivel miNivel) {
		this.miNivel = miNivel;
	}
	
	public void run () {
		int ContTotal = 0;
		Iterator <Integer> Oleada = miNivel.getEnemigosPorOleada ().iterator ();
		int ContOleada = (Integer) Oleada.next ();
		Bloqueo = true;
		while (ContTotal < this.miNivel.getCantidadEnemigos ()) {
			System.out.println ();
			while (!Bloqueo) {
				if (ContTotal == ContOleada) {
					Bloqueo = true;
					if (!Oleada.hasNext ()) {
						break;
					}
					miNivel.getTienda ().getMarket ().setBotonOleadaOn ();
					ContOleada = (Integer) Oleada.next ();
				}
				else {
					miNivel.mandarEnemigo ();
					ContTotal++;
					try {
						Thread.sleep (3000);
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public void Desbloquear () {
		Bloqueo = false;
	}
}