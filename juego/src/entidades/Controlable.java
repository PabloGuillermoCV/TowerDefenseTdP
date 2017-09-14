package entidades;

public abstract class Controlable extends personaje{

	public void serAtacado(Controlable a){
		//Hace nada, NO hay fuego amigo
	}
	
	public void serAtacado(enemigo e){
		this.setVida(this.vida -  (this.defensa - e.getAtaque()) );
	}
}
