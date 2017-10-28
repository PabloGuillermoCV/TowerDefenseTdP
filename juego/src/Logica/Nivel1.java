package Logica;

import GUI.*;

public class Nivel1 extends Nivel {
	
	public Nivel1 (GUI gui) {
		miGui = gui;
		posFinalEnemies = new Posicion (480,300);
		mapaLogico = MapaLogico.InstanciaMapaLogico ();
		mapaLogico.setMapaVisual (miGui.getMapaVisual());
		mapaLogico.generarCaminoA (posFinalEnemies);
		tiendaLogica = TiendaLogica.InstanciaTiendaLogica ();
		fabrica = new FabricaEnemigos ();
				
		generarListaEnemigos ();
	}
	
	/**
	 * modificar para que cree uno de cada uno
	 */
	public void generarListaEnemigos () {
		fabrica.crearAPie ();
		fabrica.crearACaballo ();
	}
	
	public MapaLogico getMapa () {
		return mapaLogico;
	}
	
	@Override
	public void siguienteNivel() {
		Nivel sig = new Nivel2(miGui);
		sig.generarListaEnemigos();
		miGui.setNivel(sig);
		
	}
}