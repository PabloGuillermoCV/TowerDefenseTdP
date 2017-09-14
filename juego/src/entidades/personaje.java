package entidades;

import Mapa.powerUpDelMapa;

public abstract class personaje extends fisico {

	protected int vida;
	protected int alcance;
	protected powerUpDelMapa powerUp;
	protected int ataque;
	protected int defensa;
	
	public abstract void serAtacado(Controlable a);
	
	public abstract void serAtacado(enemigo e);
	
	public int getVida(){
		return vida;
	}
	public void atacar(personaje p){
		p.serAtacado(this);
	}
	public void setVida(int v){
		vida = v;
	}
	public int getAtaque(){
		return ataque;
	}
	
	public int getDefensa(){
		return defensa;
	}

}
