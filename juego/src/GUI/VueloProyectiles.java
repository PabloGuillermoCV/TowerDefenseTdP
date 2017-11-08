package GUI;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import entidades.Proyectil;

public class VueloProyectiles extends Thread {
	
	private volatile Collection<Proyectil> proyectiles;
	private volatile Collection<Proyectil> proyectilesEliminar;
	private static VueloProyectiles Yo;
	
	private VueloProyectiles() {
		proyectiles = new LinkedList<Proyectil>();
		proyectilesEliminar = new LinkedList<Proyectil>();
	}
	
	public static VueloProyectiles getInstance() {
		if(Yo == null) {
			Yo = new VueloProyectiles();
			Yo.start();
		}
		return Yo;
	}
	public void agregarProyectil(Proyectil p) {
		proyectiles.add(p);
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
