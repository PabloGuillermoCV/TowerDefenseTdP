package entidades.Estados;

public class EstadoDebil extends Estado {
	
	public EstadoDebil (int Vida, int Ataque, int Defensa) {
		Ataque = (Ataque / 25) / 100;
		this.Ataque = Ataque;
		this.Vida = Vida;
		this.Defensa = Defensa;
	}
}