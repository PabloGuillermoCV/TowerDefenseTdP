package entidades.Estados;

public abstract class Estado {
	
	protected int Vida;
	protected int Ataque;
	protected int Defensa;
	
	public Estado () {}
	
	public int getVida () {
		return Vida;
	}
	
	public int getAtaque () {
		return Ataque;
	}
	
	public int getDefensa () {
		return Defensa;
	}
	
	public void setVida (int V) {
		Vida = V;
	}
	
	public void setAtaque (int A) {
		Ataque = A;
	}
	
	public void setDefensa (int D) {
		Defensa = D;
	}
}