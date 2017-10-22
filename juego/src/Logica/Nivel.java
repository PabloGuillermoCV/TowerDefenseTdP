package Logica;

import GUI.*;
/*import java.util.Collection;
import java.util.LinkedList;
import entidades.*;*/

public abstract class Nivel {
	protected AbstractFactory fabrica;
	//protected Collection <Enemigo> enemigos;
	protected MapaLogico mapaLogico;
	protected TiendaLogica tiendaLogica;
	protected GUI miGui;
	protected Posicion posFinalEnemies;
	//protected Collection<Controlable> unidadesEnMapa; //unidades aliadas
	
	/**
	 * realiza la interaccion entre controlables y enemigos
	 */
	
	public abstract void InteraccionControlableEnemigo();
	
	public abstract void moverEnemigos();
	/**
	 * genera la lista de enemigos que van a estar en el nivel
	 */
	protected abstract void generarListaEnemigos();
	
	/**
	 * utilizando el camino generado movera a cada enemigo a la siguiente Celda
	 */
	//public abstract void moverEnemigos();
	
	public abstract MapaLogico getMapa();
	
	public abstract TiendaLogica getTienda();
	
	
	
	
}