package GUI;

import Creadores.Factory;

public class Tienda {

	protected Factory creator;
	protected int oroJugador; 
	
	public Tienda(){
		creator = null;
		oroJugador = 1000;
	}
	
	public void setCreador(Factory f){
		creator = f;
	}
		
	public Factory getCreador(){
		return creator;
	}
	
	public int getOro(){
		return oroJugador;
	}
}
