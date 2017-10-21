package entidades.Estados;

public class EstadoEscudo extends Estado {
	
	public EstadoEscudo (int Vida, int Ataque, int Defensa) {
		Defensa = (Defensa * 25) / 100;
		this.Defensa = Defensa;
		this.Vida = Vida;
		this.Ataque = Ataque;
	}
}