package Objetos.ObjTemporal;

import Hilos.HiloItemTemporal;
import Logica.Posicion;
import entidades.Controlable;
import entidades.Enemigo;
import entidades.Objeto;

public abstract class ObjetoTemporal extends Objeto {
	
	protected Enemigo auxiliar; //Lo uso para guardar el enemigo y recuperar su estrategia de movimiento
	
	/**
	 * constructor del Item Temporal
	 * @param Nombre nombre del item
	 * @param Pos posicion donde aparece en el mapa
	 * @param Tiempo �cu�nto tiempo estar� en el mapa?
	 * tambi�n crea un Hilo que controla cuanto tiempo vive
	 */
	public ObjetoTemporal (String Nombre, Posicion Pos, int Tiempo) {
		super (Nombre,Pos);
		this.auxiliar = null;
		HiloItemTemporal miHilo = new HiloItemTemporal (this, Tiempo);
		miHilo.start ();
	}
	
	/**
	 * m�todo que se encarga de romper todo vinculo del item para que "Desaparezca"
	 * este m�todo es llamado por el Hilo de Items Temporales
	 */
	public void morir () {
		//auxiliar.setEstrategia (new CaminarNormal (auxiliar));
		auxiliar = null;
	}
	
	public void Afectar (Controlable E) {}
	
	public Objeto Agarrar () {
		return null;
	}
}