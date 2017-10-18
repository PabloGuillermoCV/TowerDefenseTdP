package Logica;

import java.util.Collection;
import java.util.LinkedList;

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
	protected Collection<Controlable> unidadesEnMapa; //unidades aliadas
	
	/**
	 * es una prueba
	 */
	public abstract void mover();
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
	
	/**
	 * metodo que agrega una unidad aliada a la Lista de aliados cuando fue creada (se lo llama desde la TiendaLogica
	 * @param E Aliadoa a agregar
	 */
	public void agregarUnidadAliada(Controlable E){
		unidadesEnMapa.add(E);
	}
	
	/**
	 * metodo que se encarga de orquestar los ataques entre Aliados y Enemigos
	 * También pregunta si alguna unidad de las dos partes murió y la agrega a una lista específica para luego borrarlos
	 */
	public void verificarUnidadesEnRango(){
		Collection<Enemigo> aEliminarE = new LinkedList<Enemigo>(); //lista donde guardo los enemigos a eliminar despues
		Collection<Controlable> aEliminarC = new LinkedList<Controlable>(); //lista donde guardo los aliados a eliminar despues
		for(Controlable E: unidadesEnMapa){ //para cada Aliado en el Mapa
			Collection<Enemigo> att = mapaLogico.getUnidadesEnRango(E); 
			if(!att.isEmpty()){ //si la lista de enemigos a atacar NO es vacia
				for(Enemigo g: att){
					g.serAtacado(E); //le pido al enemigo que se ataque y delego en el Visitor
					if(g.getVida() <= 0) //si el enemigo murió
						aEliminarE.add(g);
					if(!aEliminarE.contains(g) && mapaLogico.estaEnRango(g,E)){ //si el Enemigo NO se murio y puede atacar al Aliado que lo atacó
						E.serAtacado(g); //le pido al aliado que se ataque y delego en el Visitor
					}
					if(E.getVida() <= 0){ //si el aliado murió
						aEliminarC.add(E);
					}
					
				}
			}
		}
		if(!aEliminarE.isEmpty()){
			for(Enemigo E : aEliminarE){
				//hay que eliminarlo graficamente primero
				//dar Oro y puntos al Jugador
				System.out.println("Murio un Enemigo");
				enemigos.remove(E); //esto sacaria a la unidad de la lista, pero creo que sigue dando vueltas por alguna parte del juego y NO lo puedo borrar con finalize() de Object
			}
		}
		if(!aEliminarC.isEmpty()){
			for(Controlable C: aEliminarC){
				//hay que elminarlo graficamente primero
				unidadesEnMapa.remove(C); //esto sacaria a la unidad de la lista, pero creo que sigue dando vueltas por alguna parte del juego y NO lo puedo borrar con finalize() de Object
			}
		}
	}
	
	
	


}
