package Logica;

import GUI.MapaVisual;
import Logica.Niveles.Nivel;
import entidades.Controlable;
import entidades.Enemigo;
import entidades.Objeto;

public interface MapaLogicoI {
	public static MapaLogicoI InstanciaMapaLogico () {
		return null;
	}
	public void setNivel(Nivel n);
	public void setMapaVisual(MapaVisual MV);
	public void interaccionControlableEnemigo ();
	public MapaVisual getMapaVisual();
	public boolean puedoAgregarControlable (Posicion pos);
	public boolean puedoAgregarObjetoDeTienda (Posicion pos);
	public void agregarControlable (Controlable c, Posicion pos);
	public void agregarEnemigo (Enemigo e);
	public void agregarObjeto (Objeto O);
	public boolean posicionValidaEnMapa (int X, int Y);
	public void eliminarControlable (Controlable C);
	public void eliminarEnemigo (Enemigo E);
	public void eliminarObjeto (Objeto O);
	public void eliminarTodo ();
	
	
	
}
