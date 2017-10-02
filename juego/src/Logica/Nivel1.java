package Logica;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import GUI.*;
import entidades.*;

public class Nivel1 extends Nivel {
	
	public Nivel1(GUI gui) {
		miGui=gui;
		mapaLogico= new MapaLogico(gui.getMapaVisual().getWidth(),gui.getMapaVisual().getHeight());
		tiendaLogica = new TiendaLogica();
		fabrica= new FabricaEnemigos();
		enemigos = new LinkedList<Enemigo>();
		camino = new Camino1();
		posFinalEnemys = new Posicion (400,340);
		camino.generarCaminoA(posFinalEnemys);
		
		generarListaEnemigos();
	}
	/**
	 * modificar para que cree uno de cada uno
	 */
	public void generarListaEnemigos() {
		int total=7;
		for(int i=0; i<=total;i++) {
			enemigos.add(fabrica.crearAPie());
		}
	}

	public  void moverEnemigos() {
		Posicion pos = new Posicion (0,0);
		LinkedList<Enemigo> aux;
		Map<Enemigo,Boolean> mapeo = new HashMap<Enemigo,Boolean>();
		
		while(camino.getNext(pos)!=null) {
			Celda c= mapaLogico.getCelda(pos.getX(),pos.getY());
			aux= c.getEnemigos();
			if(!aux.isEmpty()) {
				boolean corte=false;
				Enemigo e = aux.removeFirst();
				
				while(!corte) {
					boolean esta = mapeo.get(e);
					if (!esta) {
						//e.moverA(camino.getNext(pos));
						mapeo.put(e, true);
						corte=true;
					}	
					else {
						if(!aux.isEmpty())
							e=aux.removeFirst();
						else
							corte=true;
					}
				}
			}	
				
			pos= camino.getNext(pos);
		}	
		
		
	}
	
	public Camino getCamino() {
		
		return camino;
	}
	
	public MapaLogico getMapa() {
		
		return mapaLogico;
	}
	
	public TiendaLogica getTienda() {
		
		return tiendaLogica;
	}



}
