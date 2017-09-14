package entidades;

public abstract class enemigo extends personaje {

	public void serAtacado(Controlable a){
		this.setVida(this.vida -  (this.defensa - a.getAtaque()) );
	}
	
	public  void serAtacado(enemigo e){}
}
