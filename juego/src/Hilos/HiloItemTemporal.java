package Hilos;

import Objetos.ObjTemporal.ObjetoTemporal;

public class HiloItemTemporal extends Thread {

	private ObjetoTemporal miObjeto;
	private int Time;
	
	public HiloItemTemporal (ObjetoTemporal miObjeto, int Time) {
		this.miObjeto = miObjeto;
		this.Time = Time;
	}
	
	public void run () {
		Time = Time * 1000;
		try {
			HiloItemTemporal.sleep (Time);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		miObjeto.morir();
	}
}