package Logica;

import java.util.Collection;
import java.util.LinkedList;

import entidades.Controlable;
import entidades.Enemigo;

public class MapaLogico {
	
	private static MapaLogico Instancia;
	private Celda [][] matriz;
	private static int tamaño = 20;
	//private TiendaLogica market;
	
	/**
	 * constructor : inicializa la matriz de Celdas con un total de (el Ancho del Mapa)/20 por
	 * (alto del Mapa)/20. Usamos 20*20 por el tamaño del Sprite. Luego de inicializar la Matriz
	 * creamos cada Celda perteneciente a la matriz y le enviamos la posicion de su esquina izq.
	 */
	
	private MapaLogico (int w, int h) {
		matriz = new Celda [w/tamaño][h/tamaño];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz [0].length; j++) {
				matriz [i][j] = new Celda (i*tamaño,j*tamaño,this);
				
			}
		}
		//TiendaLogica market = new TiendaLogica();
	}
	
	public static MapaLogico InstanciaMapaLogico (int w, int h) {
		if (Instancia == null) {
			Instancia = new MapaLogico (w, h);
		}
		return Instancia;
	}
	
	public Celda getCelda (int x,int y) {
		return matriz [x/tamaño] [y/tamaño];
	}
	
	public int getTamaño () {
		return tamaño;
	}
	/*
	public void agregarPersonaje(int x,int y) {
		market.getControlable();
		//if(Market.getCreador() != null)
			//modificar no recibe la celda --> Market.getCreador();
		
	}
*/

	/**
	 * metodo que verifica las unidades que un Aliado puede atacar
	 * @param e Aliado en cuestion a verficar Rango
	 * @return Colección de enemigos a atacar
	 */
	public Collection<Enemigo> getUnidadesEnRango(Controlable e) {
		Collection<Enemigo> ret = new LinkedList<Enemigo>();
		/*NOTA: estoy teniendo un problema en COMO recorrer el rango efectivo de la unidad
		 * calculo que se deberia hacer con un for doble anidado para que recorra primero el eje X y despues el Eje Y, 
		 * pero el drama viene que tendria que hacer DOS for dobles anidados, uno que verifique la parte de X y otro que verifique la parte de Y
		 * para esto, subiré una foto de un dibujo que hice para que se entienda el problema, veanlo en el Drive
		 * dejo este código incompleto ya que es una idea de como se me ocurrió empezar, la referencia se entenderá mejor con la foto del Drive
		*/
		int X;
		int Y;
		for(int r = e.getAlcance(); r > 0; r--) {
			X = r;
			for(Y = r; Y > 0; Y--) {
				if(!getCelda(-X,Y).getEnemigos().isEmpty())
					ret.add(getCelda(-X,Y).getEnemigos().getFirst());
				else {
					if(!getCelda(X,-Y).getEnemigos().isEmpty())
						ret.add(getCelda(X,-Y).getEnemigos().getFirst());
					else
						if(!getCelda(X,Y).getEnemigos().isEmpty())
							ret.add(getCelda(X,Y).getEnemigos().getFirst());
						else
							if(!getCelda(-X,-Y).getEnemigos().isEmpty())
								ret.add(getCelda(-X,-Y).getEnemigos().getFirst());
				}
			}
			Y = r;
			for(X = r; X > 0; X--) {
				if(!getCelda(-X,Y).getEnemigos().isEmpty())
					ret.add(getCelda(-X,Y).getEnemigos().getFirst());
				else {
					if(!getCelda(X,-Y).getEnemigos().isEmpty())
						ret.add(getCelda(X,-Y).getEnemigos().getFirst());
					else
						if(!getCelda(X,Y).getEnemigos().isEmpty())
							ret.add(getCelda(X,Y).getEnemigos().getFirst());
						else
							if(!getCelda(-X,-Y).getEnemigos().isEmpty())
								ret.add(getCelda(-X,-Y).getEnemigos().getFirst());
			}
		}
		
		
		}
	return ret;
	}

	public boolean estaEnRango(Enemigo g, Controlable e) {
		boolean esta = false;
		int X;
		int Y;
		for(int r = g.getAlcance(); r > 0 && !esta; r--) {
			X = r;
			for(Y = r; Y > 0 && !esta; Y--) {
				if(getCelda(-X,Y).getPersonaje() == e)
					esta = true;
				else {
					if(getCelda(X,-Y).getPersonaje() == e)
						esta = true;
					else
						if(getCelda(X,Y).getPersonaje() == e)
							esta = true;
						else
							if(getCelda(-X,-Y).getPersonaje() == e)
								esta = true;
				}
			}
			Y = r;
			for(X = r; X > 0 && !esta; X--) {
				if(getCelda(-X,Y).getPersonaje() == e)
					esta = true;
				else {
					if(getCelda(X,-Y).getPersonaje() == e)
						esta = true;
					else
						if(getCelda(X,Y).getPersonaje() == e)
							esta = true;
						else
							if(getCelda(-X,-Y).getPersonaje() == e)
								esta = true;
			}
		}
		
		
		}
		return esta;
	}
}