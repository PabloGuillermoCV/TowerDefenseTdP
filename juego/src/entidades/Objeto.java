package entidades;

import Logica.Posicion;

public abstract class Objeto extends Entidad {
	
	public Objeto (String Nombre, Posicion Pos) {
		super (Nombre, Pos);
	}
	
	//Implementado por objetos que afecten a todos los personajes
	public abstract void Afectar (Personaje P);
	
	//Implementado por objetos que afecten solamente a controlables
	public abstract void Afectar (Controlable C);
	
	//Implementado por objetos que afecten solamente a enemigos
	public abstract void Afectar (Enemigo E);
	
	//Saca el objeto del mapa
	public abstract Objeto Agarrar ();
}