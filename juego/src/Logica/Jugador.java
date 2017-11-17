package Logica;

public class Jugador implements JugadorI{
	
	private static Jugador Instancia;
	protected int Monedas;
	protected int Puntos;
	protected int Vidas;
	
	private Jugador () {
		Monedas = 1000;
		Puntos = 0;
		Vidas = 3;
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
	
	public int getVida () {
		return Vidas;
	}
	
	public void setMonedas (int M) {
		Monedas = M;
	}
	
	public void setPuntos (int P) {
		Puntos = P;
	}
	
	public void restarVida () {
		Vidas = Vidas - 1;
	}
	
	public void restablecerVidas () {
		Vidas = 3;
		if(Monedas < 1000) 
			Monedas = 1000;
	}

	

	
}