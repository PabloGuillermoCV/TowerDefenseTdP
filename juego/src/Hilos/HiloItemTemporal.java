package Hilos;

import Objetos.ObjTemporal.ObjetoTemporal;

public class HiloItemTemporal extends Thread {

	private ObjetoTemporal item;
	private int cont;
	
	public HiloItemTemporal (int time) {
		cont = time;
	}
	
	public void setItem (ObjetoTemporal o) {
		item = o;
	}
	
	public void run () {
		while (cont > 0) {
			cont--;
			try {
				HiloItemTemporal.sleep(1000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		item.morir();
	}
}