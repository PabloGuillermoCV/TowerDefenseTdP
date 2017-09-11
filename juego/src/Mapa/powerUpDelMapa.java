package Mapa;

import entidades.enemigo;

public abstract class powerUpDelMapa extends objDentroDelMapa{
	
	protected enemigo contieneEnemigo;
	
	public enemigo getEnemigo(){
		return contieneEnemigo;
	}
}
