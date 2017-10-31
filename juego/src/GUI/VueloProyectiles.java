package GUI;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import Logica.Nivel;
import entidades.Proyectil;

public class VueloProyectiles extends Thread {
	
	private Collection<Proyectil> proyectiles;
	private Collection<Proyectil> proyectilesEliminar;
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
	public void run() {
			Iterator<Proyectil> disp = proyectiles.iterator();
			System.out.println("Estoy volando proyectiles");
			while(disp.hasNext()) {
				Proyectil p = disp.next();
				if(!proyectilesEliminar.contains(p))
					p.volar();
				try {
					this.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			for(Proyectil P: proyectilesEliminar) {
				proyectiles.remove(P);
			}	
		}
	
}
