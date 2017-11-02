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
		}
		return Yo;
	}
	public void agregarProyectil(Proyectil p) {
		proyectiles.add(p);
	}
	
	public void eliminarProyectil(Proyectil p) {
		if(proyectiles.contains(p))
			proyectilesEliminar.add(p);
	}
	@SuppressWarnings("static-access")
	public void run() {
		while(true) {
			Iterator<Proyectil> disp = proyectiles.iterator();
			
			while(disp.hasNext()) {
				Proyectil p = disp.next();
				if(!p.llegoAlFinal())
					p.volar();
				else
					proyectilesEliminar.add(p);
				try {
					this.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			disp = proyectilesEliminar.iterator();
			while(disp.hasNext()) {
				Proyectil p = disp.next();
				proyectiles.remove(p);
				proyectilesEliminar.remove(p);
			}
		}	
	}
	
}
