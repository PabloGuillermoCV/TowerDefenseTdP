package entidades.Estados;

public class EstadoAtaque extends Estado {
	
	public EstadoAtaque (int Vida, int Ataque, int Defensa) {
		Ataque = (Ataque * 25) / 100;
		this.Ataque = Ataque;
		this.Vida = Vida;
		this.Defensa = Defensa;
	}
}