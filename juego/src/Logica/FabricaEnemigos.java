package Logica;

import entidades.*;
import Enemigos.*;

public class FabricaEnemigos implements AbstractFactory {

	/**
	 * ver de si la fabrica los crearia a todos siempre en la posicion inicial (0,0) y si es asi
	 * solo faltaria completar los otros metodos creando y deolviendo un soldado en pos inicial
	 */
	public Enemigo crearAPie() {
		return new APie (new Posicion (0,0));
	}

	
	public Enemigo crearACaballo() {
		return new ACaballo (new Posicion (0,0));
	}

	
	public Enemigo crearConArmadura() {
		return new ConArmadura (new Posicion (0,0));
	}

	
	public Enemigo crearConArco() {
		return new ConArco (new Posicion (0,0));
	}

	
	public Enemigo crearConBallesta() {
		return new ConBallesta (new Posicion (0,0));
	}

	
	public Enemigo crearJefeFinal() {
		return new JefeFinal (new Posicion (0,0));
	}
}