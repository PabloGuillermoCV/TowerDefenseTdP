package Logica;

/*import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import javax.swing.JLabel;*/

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
				
		generarListaEnemigos ();
	}
	
	
	/**
	 * modificar para que cree uno de cada uno
	 */
	public void generarListaEnemigos() {
		Enemigo APie = fabrica.crearAPie();
		
		mapaLogico.agregarEnemigo(APie);
		
		
			
	
	}
	public void moverEnemigos() {
		for (Enemigo e : mapaLogico.getListaEnemigos())
			e.Mover();
	}
		
	public void InteraccionControlableEnemigo() {
		Enemigo e;
		for (  Controlable C  : mapaLogico.getListaControlables()) {
			 e = C.verificarUnidad();
			if (e!=null)
				e.serAtacado(C);
		}
	}
	
	
		
	public MapaLogico getMapa() {
		
		return mapaLogico;
	}
	
	public TiendaLogica getTienda() {
		
		return tiendaLogica;
	}
}