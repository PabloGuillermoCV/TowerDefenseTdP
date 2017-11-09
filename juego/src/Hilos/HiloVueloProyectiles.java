package Hilos;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import entidades.Proyectil;

public class HiloVueloProyectiles extends Thread {
	
	private volatile Collection<Proyectil> proyectiles;
	private volatile Collection<Proyectil> proyectilesEliminar;
	private volatile Collection<Proyectil> aAgregar;
	private static HiloVueloProyectiles Instancia;
	
	private HiloVueloProyectiles() {
		proyectiles = new LinkedList<Proyectil>();
		proyectilesEliminar = new LinkedList<Proyectil>();
		aAgregar = new LinkedList<Proyectil>();
	}
	
	public static HiloVueloProyectiles InstanciaHiloVueloProyectiles () {
		if(Instancia == null) {
			Instancia = new HiloVueloProyectiles ();
			Instancia.start ();
		}
		return Instancia;
	}
	public void agregarProyectil(Proyectil p) {
		aAgregar.add(p);
	}
	
	@SuppressWarnings("static-access")
	public void run() {
		while(true) {
			Iterator<Proyectil> disp = proyectiles.iterator();
			while(disp.hasNext()) {
				Proyectil p = disp.next();
				if(!p.llegoAlFinal() && !proyectilesEliminar.contains(p))
					p.volar();
				else
					proyectilesEliminar.add(p);
				try {
					System.out.println("HOLA");
					this.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			eliminacion();
			Agregacion();
		}	
	}
	
	private void Agregacion() {
		if(!aAgregar.isEmpty()) {
			proyectiles.addAll(aAgregar);
			aAgregar.removeAll(aAgregar);
		}
	}

	private synchronized void eliminacion() {
		proyectiles.removeAll(proyectilesEliminar);
		for(Proyectil P: proyectilesEliminar){
			P.Morir();
		}
		proyectilesEliminar.removeAll(proyectilesEliminar); //le digo a la misma lista que elmine todos sus elementos
	}
	
}
