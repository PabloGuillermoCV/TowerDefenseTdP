package Logica;

import entidades.*;

public interface AbstractFactory {
	
	public Enemigo crearAPie (Posicion P);
	
	public Enemigo crearACaballo (Posicion P);
	
	public Enemigo crearConArmadura (Posicion P);
	
	public Enemigo crearConArco (Posicion P);
	
	public Enemigo crearConBallesta (Posicion P);
	
	public Enemigo crearJefeFinal (Posicion P);
}
