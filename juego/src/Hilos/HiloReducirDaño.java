package Hilos;

import entidades.Enemigo;
import entidades.Estados.EstadoDebil;
import entidades.Estados.EstadoNormal;

public class HiloReducirDa�o extends Thread {
	
	private Enemigo miEnemigo;
	
	public HiloReducirDa�o (Enemigo miEnemigo) {
		this.miEnemigo = miEnemigo;
	}
	
	public void run () {
		int V = this.miEnemigo.getEstado ().getVida ();
		int A = this.miEnemigo.getEstado ().getAtaque ();
		int D = this.miEnemigo.getEstado ().getDefensa ();
		this.miEnemigo.setEstado (new EstadoDebil (V,A,D));
		try {
			HiloInvencibilidad.sleep (5000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.miEnemigo.setEstado (new EstadoNormal (V,A,D));
	}
}