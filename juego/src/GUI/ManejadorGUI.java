package GUI;

import Logica.*;

/**
 * clase que se encarga de hacer los pasajes entre frames del juego
 * @author Pablo Guillermo Ceballos Vitale
 *
 */
public class ManejadorGUI {
	
	private Nivel[] Niveles;
	@SuppressWarnings("unused")
	private Juego menuppal;
	private GUI mapa;
	
	public ManejadorGUI() {
		mapa = GUI.InstanciaGUI ();
		Niveles = new Nivel[3];
		Niveles[0] = new Nivel1(mapa);
		Niveles[1] = new Nivel2();
		Niveles[2] = new Nivel3();
		menuppal = new Juego();
	}

	public Nivel siguienteNivel(int niv) {
		if(niv != 3) {
			return Niveles[niv + 1];
		}
		else return null;
	}
}
