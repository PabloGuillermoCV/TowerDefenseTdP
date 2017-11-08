package Objetos.ObjsDeLaTienda;

import entidades.Controlable;
import entidades.Personaje;
import Hilos.HiloItemTemporal;

public class Armadura extends ObjDeLaTienda {
	
	public Armadura () {
		super ("Armadura", null, 200, 25);
		int Tiempo = 50;
		HiloItemTemporal miHilo = new HiloItemTemporal (Tiempo);
		miHilo.start ();
	}
	
	public void Afectar (Personaje P) {}
	
	public void Afectar (Controlable C) {
		//Vuelve invencible al controlable por una cierta cantidad de tiempo, luego llama a fininvincibilidad
		
	}
	
	public void FinInvincibilidad (Controlable C) {
		
	}
}