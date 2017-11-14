package Logica;

import entidades.*;
import entidades.Estados.*;
import java.util.Random;
import Enemigos.*;

public class FabricaEnemigos implements AbstractFactory {

	public Enemigo crearAPie (Posicion P) {
		APie E = new APie (new Posicion (P.getX (), P.getY ()));
		Mejorar (E);
		return E;
	}

	
	public Enemigo crearACaballo (Posicion P) {
		ACaballo E = new ACaballo (new Posicion (P.getX (), P.getY ()));
		Mejorar (E);
		return E;
	}

	
	public Enemigo crearConArmadura (Posicion P) {
		ConArmadura E = new ConArmadura (new Posicion (P.getX (), P.getY ()));
		Mejorar (E);
		return E;
	}

	
	public Enemigo crearConArco (Posicion P) {
		ConArco E = new ConArco (new Posicion (P.getX (), P.getY ()));
		Mejorar (E);
		return E;
	}

	
	public Enemigo crearConBallesta (Posicion P) {
		ConBallesta E = new ConBallesta (new Posicion (P.getX (), P.getY ()));
		Mejorar (E);
		return E;
	}

	
	public Enemigo crearJefeFinal (Posicion P) {
		JefeFinal E = new JefeFinal (new Posicion (P.getX (), P.getY ()));
		Mejorar (E);
		return E;
	}
	
	private void Mejorar (Enemigo E) {
		Random Rand = new Random ();
		int I = Rand.nextInt (100) + 1; //Probabilidad de dejar caer un objeto
		if (I <= 20) {
			int V = E.getEstado ().getVida ();
			int A = E.getEstado ().getAtaque ();
			int D = E.getEstado ().getDefensa ();
			I = Rand.nextInt (3) + 1;
			switch (I) {
				case 1:
					E.setEstado (new EstadoVida (V,A,D));
					break;
				case 2:
					E.setEstado (new EstadoAtaque (V,A,D));
					break;
				case 3:
					E.setEstado (new EstadoEscudo (V,A,D));
					break;
			}
		}
	}
}