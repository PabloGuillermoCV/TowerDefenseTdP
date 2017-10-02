package Logica;

import entidades.*;
import Enemigos.*;

public class FabricaEnemigos implements AbstractFactory {

	/**
	 * ver de si la fabrica los crearia a todos siempre en la posicion inicial (0,0) y si es asi
	 * solo faltaria completar los otros metodos creando y deolviendo un soldado en pos inicial
	 */
	public Enemigo crearAPie() {
		
		return new APie(new Posicion(0,0));
	}

	
	public Enemigo crearACaballo() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Enemigo crearConArmadura() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Enemigo crearConArco() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Enemigo crearConBallesta() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Enemigo crearJefeFinal() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
