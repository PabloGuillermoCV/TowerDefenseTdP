package Objetos.ObjTemporal;

import Logica.HiloItemTemporal;
import Logica.Posicion;
import entidades.Objeto;

public abstract class ObjetoTemporal extends Objeto {
	
	/**
	 * constructor del Item Temporal
	 * @param Nombre nombre del item
	 * @param Pos posicion donde aparece en el mapa
	 * @param Tiempo ¿cuánto tiempo estará en el mapa?
	 * también crea un Hilo que controla cuanto tiempo vive
	 */
	public ObjetoTemporal (String Nombre, Posicion Pos, int Tiempo) {
		super (Nombre,Pos);
		HiloItemTemporal miHilo = new HiloItemTemporal(Tiempo);
		miHilo.start();
	}
	
	/**
	 * método que se encarga de romper todo vinculo del item para que "Desaparezca"
	 * este método es llamado por el Hilo de Items Temporales
	 */
	public void morir() {
		// TODO Auto-generated method stub
	}
}