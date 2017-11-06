package Hilos;

import entidades.Enemigo;

public class HiloEnemigo extends Thread {
	
	private volatile Enemigo e;
	
	public void setEnemigo (Enemigo e) {
		this.e = e;
	}
	
	public void run () {
		while (true) {
			if (e != null) {
				e.Mover ();
			}
			else {
				try {
					Thread.sleep (1000);
				}
				catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
	public boolean estaLibre () {
		return e == null;
	}
	
	public Enemigo getEnemigo () {
		return e;
	}
}