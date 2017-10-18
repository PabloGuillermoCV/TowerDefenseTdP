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
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				System.out.println("error en el thread");
				e.printStackTrace();
			}
			nivel.mover();
			nivel.verificarUnidadesEnRango();
		}
	}
}