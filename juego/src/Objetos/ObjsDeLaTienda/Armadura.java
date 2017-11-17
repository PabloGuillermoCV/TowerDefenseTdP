package Objetos.ObjsDeLaTienda;

import entidades.Controlable;
import Hilos.HiloInvencibilidad;

public class Armadura extends ObjDeLaTienda {
	
	private HiloInvencibilidad miHilo;
	
	public Armadura () {
		super ("Armadura", null, 200, 25);
	}
	
	public void Afectar (Controlable C) {
		//Vuelve invencible al controlable por una cierta cantidad de tiempo, luego llama a fininvincibilidad
		miHilo = new HiloInvencibilidad (this, C);
		miHilo.run ();
	}
	
	public void ActivarInvincibilidad (Controlable C) {
		C.setInvulnerable (true);
	}
	
	public void FinInvincibilidad (Controlable C) {
		C.setInvulnerable (false);
	}
}