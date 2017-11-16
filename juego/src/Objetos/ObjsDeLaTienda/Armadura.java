package Objetos.ObjsDeLaTienda;

import entidades.Controlable;
import entidades.Enemigo;
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
	
	public void Afectar (Enemigo E) {}
	
	public void Afectar () {}
	
	public void ActivarInvincibilidad (Controlable C) {
		C.setInvulnerable (true);
	}
	
	public void FinInvincibilidad (Controlable C) {
		C.setInvulnerable (false);
	}
}