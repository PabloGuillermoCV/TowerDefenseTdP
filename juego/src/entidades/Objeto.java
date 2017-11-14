package entidades;

import Logica.Posicion;

public abstract class Objeto extends Entidad {
	
	public Objeto (String Nombre, Posicion Pos) {
		super (Nombre, Pos);
	}
	
	//Implementado por objetos que afecten solamente a controlables
	public abstract void Afectar (Controlable C);
	
	//Implementado por objetos que afecten solamente a enemigos
	public abstract void Afectar (Enemigo E);
	
	//Saca el objeto del mapa
	public abstract Objeto Agarrar ();
	
	//El objeto fue borrado sin ningun uso alguno
	public void Morir () {
		System.out.println("estoy en el morir de Objeto-------------------");
		this.miMapa.eliminarObjeto (this);
		
		this.grafico.Morir ();
		this.miMapa = null;
		this.grafico = null;
		this.pos = null;
	}
}