package entidades.Estados;

public class EstadoVida extends Estado {
	
	public EstadoVida (int Vida, int Ataque, int Defensa) {
		Vida = (Vida * 25) / 100;
		this.Vida = Vida;
		this.Ataque = Ataque;
		this.Defensa = Defensa;
	}
}