package Logica;

import java.util.ArrayList;
//import java.util.HashMap;
import java.util.LinkedList;
//import java.util.Map;
import java.util.Random;

import javax.swing.JLabel;

import GUI.*;
import entidades.*;

public class Nivel1 extends Nivel {
	
	public Nivel1 (GUI gui) {
		miGui = gui;
		posFinalEnemies = new Posicion (480,300);
		mapaLogico = MapaLogico.InstanciaMapaLogico ();
		mapaLogico.generarCaminoA (posFinalEnemies);
		tiendaLogica = TiendaLogica.InstanciaTiendaLogica ();
		fabrica = new FabricaEnemigos ();
		enemigos = new ArrayList <Enemigo> ();
		unidadesEnMapa = new LinkedList <Controlable> ();
		
		generarListaEnemigos ();
	}
	
	/*private  void mostrarCamino() {
		Posicion pos = new Posicion (0,0);
		int i=0;
		System.out.println("estoy aca");
		while(camino.getNext(pos)!=null) {
			System.out.println(pos.toString());
			pos= camino.getNext(pos);
			System.out.println(i++);
		}
	}*/
	
	/**
	 * modificar para que cree uno de cada uno
	 */
	public void generarListaEnemigos() {
		Enemigo APie = fabrica.crearAPie();
		enemigos.add(APie);
		Celda c = mapaLogico.getCelda(0,0);
		c.getEnemigos().addLast(APie);
		//miGui.getMapaVisual().getFondo().add(APie.getGrafico());
			
	
	}
	public void mover() {
		Enemigo APie = fabrica.crearAPie();
		Celda c = mapaLogico.getCelda(0,0);
		c.getEnemigos().addLast(APie);
		//miGui.getMapaVisual().getFondo().add(APie.getGrafico());
		Random r1= new Random();
		Posicion pos1= new Posicion (460,20);
		Posicion pos2= new Posicion(0,0);
		int dir= r1.nextInt(2);
		if (dir==0) 
		APie.MoverA(pos1);
		
		
		else 
			APie.MoverA(pos2);
			
		JLabel EtiquetaMonedas= miGui.getTiendaVisual().getPanelMonedas();
		int m =miGui.getTiendaVisual().getP().getMonedas()+50;
		miGui.getTiendaVisual().getP().setMonedas(m);
		EtiquetaMonedas.setText("Monedas: " +m );
		JLabel EtiquetaPuntos = miGui.getTiendaVisual().getPanelPuntos();
		int p = miGui.getTiendaVisual().getP().getPuntos()+10;
		miGui.getTiendaVisual().getP().setPuntos(p);
		EtiquetaPuntos.setText("Puntos: "+p);
	}
	
	
	/**

	
	public void mover () {
		Celda c;
		LinkedList <Enemigo> Aux;
		LinkedList <Enemigo> Movidos = new LinkedList <Enemigo> ();
		Posicion pos = new Posicion (0,0);
		int i=0;
		while(i<10){
			
			System.out.println("esta es la posicion 1"+pos.toString());
			c = mapaLogico.getCelda(pos.getX (), pos.getY ());
			Aux = c.getEnemigos ();
			
			System.out.println("esta es la posicion 2"+pos.toString());
			if (!Aux.isEmpty ()) {
				Enemigo Actual = Aux.getFirst (); 
				if(!fueMovido(Aux.getFirst(), Movidos)){
					Movidos.addLast(Actual);
					
					Actual.MoverA(camino.getNext(pos));
					mapaLogico.getCelda(camino.getNext(pos).getX(), camino.getNext(pos).getY()).addEnemigo(Aux.removeFirst());
					Movidos.removeLast();
				}
			}
			pos= camino.getNext(pos); 
			
			
			System.out.println("esta es la posicion"+pos.toString());
			i++;
			System.out.println(i);
		}
		
		//Movidos.removeLast();
	}
	
	private boolean fueMovido (Enemigo E, LinkedList <Enemigo> Movidos) {
		return Movidos.contains(E);
	}

	**/

	
	/*public  void moverEnemigos() {
		Posicion pos = new Posicion (0,0);
		LinkedList<Enemigo> aux;
		Map<Enemigo,Boolean> mapeo = new HashMap<Enemigo,Boolean>();
		
		//mapaLogico.getCelda(pos.getX(),pos.getY()).getEnemigos().addLast(fabrica.crearAPie());
		
		while(camino.getNext(pos)!=null) {
			//System.out.println(pos.toString());
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
		
		
	}*/
	
	public MapaLogico getMapa() {
		
		return mapaLogico;
	}
	
	public TiendaLogica getTienda() {
		
		return tiendaLogica;
	}
}