package Logica;

public interface JugadorI {
	public JugadorI getInstance();
	
	public int getMonedas();
	public int getPuntos();
	public int getVida();
	
	public void setMonedas(int m);
	public void setPuntos (int p);
	public void restarVida();
	
	public void restablecerVidas();
}
