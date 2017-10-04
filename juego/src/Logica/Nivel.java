package Logica;

import java.util.Collection;

import entidades.*;
import GUI.*;


public abstract class Nivel {
	protected AbstractFactory fabrica;
	protected Collection <Enemigo> enemigos;
	protected Camino camino;
	protected MapaLogico mapaLogico;
	protected TiendaLogica tiendaLogica;
	protected GUI miGui;
	protected Posicion posFinalEnemys;
	
	/**
	 * genera la lista de enemigos que van a estar en el nivel
	 */
	protected abstract void generarListaEnemigos();
	
	/**
	 * utilizando el camino generado movera a cada enemigo a la siguiente Celda
	 */
	public abstract void moverEnemigos();
	
	public abstract Camino getCamino();
	
	public abstract MapaLogico getMapa();
	
	public abstract TiendaLogica getTienda();
	
	
	


}
