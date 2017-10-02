package Logica;

import entidades.*;

public interface AbstractFactory {
	public Enemigo crearAPie();
	
	public Enemigo crearACaballo();
	
	public Enemigo crearConArmadura();
	
	public Enemigo crearConArco();
	
	public Enemigo crearConBallesta();
	
	public Enemigo crearJefeFinal();
	
}
