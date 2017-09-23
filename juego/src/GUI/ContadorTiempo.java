package GUI;

import Logica.Nivel;

public class ContadorTiempo extends Thread {

	private Nivel nivel;

	ContadorTiempo(Nivel j) {
		this.nivel = j;
	}
	
	public Nivel getNivel () {
		return nivel;
	}

	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			nivel.mover();
		}
	}
}