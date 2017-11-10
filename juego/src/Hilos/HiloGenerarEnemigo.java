package Hilos;

import java.util.Iterator;
import Logica.Niveles.Nivel;

public class HiloGenerarEnemigo extends Thread {
	
	protected Nivel miNivel;
	
	public HiloGenerarEnemigo (Nivel miNivel) {
		this.miNivel = miNivel;
	}
	
	@SuppressWarnings("rawtypes")
	public void run () {
		int ContTotal = 0;
		Iterator Oleada = miNivel.getEnemigosPorOleada ().iterator ();
		int ContOleada = (Integer) Oleada.next ();
		while (ContTotal < this.miNivel.getCantidadEnemigos () && Oleada.hasNext ()) {
			if (ContTotal == ContOleada) {
				ContOleada = (Integer) Oleada.next ();
				miNivel.getTienda ().getMarket ().setBotonOleadaOn ();
				//Aca esperaria a que aprete el boton de siguiente oleada
				try {
					Thread.sleep (6000);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
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