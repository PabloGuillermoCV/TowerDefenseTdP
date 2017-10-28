package Logica;

import GUI.*;
import entidades.Controlable;
import entidades.Enemigo;

public abstract class Nivel {
	protected AbstractFactory fabrica;
	protected MapaLogico mapaLogico;
	protected TiendaLogica tiendaLogica;
	protected GUI miGui;
	protected Posicion posFinalEnemies;
	
	/*NOTA: movi los metodos de Interaccion y de movimiento para acá arriba ya que en todos los niveles va a ser lo mismo
	 * el método siguiente nivel depende del nivel en el que se esta (obviamente)
	 */
	
	/**
	 * realiza la interaccion entre controlables y enemigos
	 */
	
	public void InteraccionControlableEnemigo(){
		Enemigo e;
		for (Controlable C : mapaLogico.getListaControlables ()) {
			System.out.println ("ESTOY EN INTERACCION-----------------------");
			e = C.verificarUnidad();
			if (e != null) {
				e.serAtacado(C);
			}
		}
	}
	
	public void moverEnemigos(){
		for (Enemigo e : mapaLogico.getListaEnemigos ()) {
			e.Mover();
			try {
				Thread.sleep(100); //si mi teoria es correcta, esto haria que las unidades se muevan con cierta distancia entre ellas
									//Mi teoria era 75% correcta, genera una separación, pero despues se vuelven a juntar
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}	
	}
	/**
	 * genera la lista de enemigos que van a estar en el nivel
	 */
	protected abstract void generarListaEnemigos();
	
	public abstract MapaLogico getMapa();
	
	/**
	 * Metodo que devuelve la TiendaLogica asociada
	 * @return TiendaLogica del  nivel (seria única, por eso la mandé para arriba)
	 */
	public  TiendaLogica getTienda(){
		return tiendaLogica;
	}
	
	/**
	 * Metodo que modifica la ventana para pasar al siguiente Nivel
	 */
	public abstract void siguienteNivel();
	
	
	
	
}