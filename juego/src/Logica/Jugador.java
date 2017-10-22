package Logica;

public class Jugador {
	
	private static Jugador Instancia;
	protected int Monedas;
	protected int Puntos;
	
	private Jugador () {
		Monedas = 200;
		Puntos = 0;
	}
	
	public static Jugador InstanciaJugador () {
		if (Instancia == null) {
			Instancia = new Jugador ();
		}
		return Instancia;
	}
	
	public int getMonedas () {
		return Monedas;
	}
	
	public int getPuntos () {
		return Puntos;
	}
	
	public void setMonedas (int M) {
		Monedas = M;
	}
	
	public void setPuntos (int P) {
		Puntos = P;
	}
}