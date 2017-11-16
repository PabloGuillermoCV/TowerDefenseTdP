package Logica;

import GUI.MapaVisual;
import entidades.Controlable;
import entidades.Enemigo;
import entidades.Objeto;

public interface MapaLogicoI {
	public  MapaLogico InstanciaMapaLogico ();
	public void interaccionControlableEnemigo ();
	public MapaVisual getMapaVisual();
	public boolean puedoAgregarControlable (Posicion pos);
	public boolean puedoAgregarObjetoDeTienda (Posicion pos);
	public void agregarControlable (Controlable c, Posicion pos);
	public void agregarEnemigo (Enemigo e);
	public void agregarObjeto (Objeto O);
	public void generarElementoDeMapa ();
	public boolean posicionValida (int X, int Y);
	public void eliminarControlable (Controlable C);
	public void eliminarEnemigo (Enemigo E);
	public void eliminarObjeto (Objeto O);
	public void eliminarTodo ();
	
	
	
}
