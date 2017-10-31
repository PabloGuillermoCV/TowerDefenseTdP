package Logica;

import entidades.*;
import Enemigos.*;

public class FabricaEnemigos implements AbstractFactory {

	/**
	 * ver de si la fabrica los crearia a todos siempre en la posicion inicial (0,0) y si es asi
	 * solo faltaria completar los otros metodos creando y deolviendo un soldado en pos inicial
	 */
	public Enemigo crearAPie (Posicion P) {
		return new APie (new Posicion (P.getX (), P.getY ()));
	}

	
	public Enemigo crearACaballo (Posicion P) {
		return new ACaballo (new Posicion (P.getX (), P.getY ()));
	}

	
	public Enemigo crearConArmadura (Posicion P) {
		return new ConArmadura (new Posicion (P.getX (), P.getY ()));
	}

	
	public Enemigo crearConArco (Posicion P) {
		return new ConArco (new Posicion (P.getX (), P.getY ()));
	}

	
	public Enemigo crearConBallesta (Posicion P) {
		return new ConBallesta (new Posicion (P.getX (), P.getY ()));
	}

	
	public Enemigo crearJefeFinal (Posicion P) {
		return new JefeFinal (new Posicion (P.getX (), P.getY ()));
	}
}