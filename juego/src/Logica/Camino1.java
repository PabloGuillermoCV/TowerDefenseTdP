package Logica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;



public class Camino1 implements Camino {
	private ArrayList<Posicion> camino;
	private static final int constante =20;
	
	/**
	 * Constructor que inicializa el arreglo
	 */
	public Camino1() {
		camino = new ArrayList<Posicion>();
		
	}
	
	/**
	 * genera el camino
	 */
	public void generarCaminoA(Posicion pos) {
		int x1 =0;		int y1=0;
		int x2 = pos.getX(); 		int y2= pos.getY();
		int auxX=x1; 			int auxY=y1;
		Random r = new Random();
		
		while(x1<x2 || y1<y2) {
			auxX=x1; auxY=y1;
			int dir = r.nextInt(3)+1;
			if (dir==1) {
				if(x1<x2) x1+=constante;
				else y1+=constante;
			} 
			else {
				if(y1<y2) y1+=constante;
				else x1+=constante;
			}	
			camino.add(new Posicion (auxX,auxY));
		}
	
		
	}
	
	/**
	 * retorna true si la posicion pertenece al camino
	 */
	
	public boolean perteneceAlCamino(Posicion pos) {
		boolean resp= false;
		if (!camino.isEmpty()) {
		
			Iterator <Posicion> it =(Iterator <Posicion>) camino.iterator();
			while(it.hasNext() && !resp) {
				Posicion pos2= it.next();
				resp= pos.getX() == pos2.getX() && pos.getY() == pos2.getY() ;
				}
			}
			
		return resp;
		}
	/**
	 * retorna la siguiente posicion del camino a la que nos pasaron por paramentro, si no existe
	 * o es la ultima retorna null
	 */
	
	public Posicion getNext(Posicion pos) {
		if (!camino.isEmpty()) {
			Posicion resp;
			boolean aviso=false;
			Iterator <Posicion> it =(Iterator <Posicion>) camino.iterator();
			while(it.hasNext()) {
				if (aviso) 
					return  it.next(); 
				else {
				Posicion pos2= it.next();
				if (pos2.getX()==pos.getX() && pos2.getY()==pos.getY())
					aviso=true;
				}
			}
	}
		return null;
	}

}