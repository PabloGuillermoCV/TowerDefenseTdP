package Hilos;

import java.util.Iterator;
import Logica.Niveles.Nivel;

public class HiloGenerarEnemigo extends Thread {
	
	protected Nivel miNivel;
	
	public HiloGenerarEnemigo (Nivel miNivel) {
		this.miNivel = miNivel;
	}
	
	public void run () {
		int ContTotal = 0;
		Iterator <Integer> Oleada = miNivel.getEnemigosPorOleada ().iterator ();
		int ContOleada = (Integer) Oleada.next ();
		/*try {
			miNivel.wait();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		while (ContTotal < this.miNivel.getCantidadEnemigos () && Oleada.hasNext ()) {
			if (ContTotal == ContOleada) {
				ContOleada = (Integer) Oleada.next ();
				miNivel.getTienda ().getMarket ().setBotonOleadaOn ();
				//Espero a que se aprete el boton de Empezar Oleada
				/*try {
					miNivel.wait();
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}*/
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