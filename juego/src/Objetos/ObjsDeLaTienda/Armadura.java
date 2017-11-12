package Objetos.ObjsDeLaTienda;

import entidades.Controlable;
import entidades.Enemigo;
import Hilos.HiloItemTemporal;

public class Armadura extends ObjDeLaTienda {
	
	public Armadura () {
		super ("Armadura", null, 200, 25);
		int Tiempo = 50;
		HiloItemTemporal miHilo = new HiloItemTemporal (Tiempo);
		miHilo.start ();
	}
	
	public void Afectar (Controlable C) {
		//Vuelve invencible al controlable por una cierta cantidad de tiempo, luego llama a fininvincibilidad
		C.setInvulnerable (true);
		try {
			Thread.sleep (1000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		FinInvincibilidad (C);
	}
	
	public void Afectar (Enemigo E) {}
	
	public void Afectar () {}
	
	public void FinInvincibilidad (Controlable C) {
		C.setInvulnerable (false);
	}
}