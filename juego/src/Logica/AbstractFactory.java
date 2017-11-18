package Logica;

import entidades.*;

/**
 * Abstract factory que luego será usada para crear unidades enemigas sin explicitar constructores donde sea necesario
 *
 */
public interface AbstractFactory {
	
	public Enemigo crearAPie (Posicion P);
	
	public Enemigo crearACaballo (Posicion P);
	
	public Enemigo crearConArmadura (Posicion P);
	
	public Enemigo crearConArco (Posicion P);
	
	public Enemigo crearConBallesta (Posicion P);
	
	public Enemigo crearJefeFinal (Posicion P);
}
