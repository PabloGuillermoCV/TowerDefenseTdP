package Logica;

public class Jugador {
	protected int Monedas;
	protected int Puntos;
	
	public Jugador () {
		Monedas = 200;
		Puntos = 0;
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