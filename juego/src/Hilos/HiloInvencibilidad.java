package Hilos;

import Objetos.ObjsDeLaTienda.Armadura;
import entidades.Controlable;

public class HiloInvencibilidad extends Thread {
	
	private Armadura miObjeto;
	private Controlable miPersonaje;
	
	public HiloInvencibilidad (Armadura miObjeto, Controlable miPersonaje) {
		this.miObjeto = miObjeto;
		this.miPersonaje = miPersonaje;
	}
	
	public void run () {
		miObjeto.ActivarInvincibilidad (miPersonaje);
		try {
			HiloInvencibilidad.sleep (5000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		miObjeto.FinInvincibilidad (miPersonaje);
	}
}