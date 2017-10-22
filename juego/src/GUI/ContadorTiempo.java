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
		//!nivel.getMapa().getListaEnemigos().isEmpty() seria la condición para el while
		// para despues cambiar de nivel
		while(true){
			try {
				nivel.InteraccionControlableEnemigo();
				Thread.sleep(3000);
				
			} catch (InterruptedException e) {
				System.out.println("error en el thread");
				e.printStackTrace();
			}
			nivel.moverEnemigos();
			
		}
	
	}
}