package entidades;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Posicion;

public abstract class Proyectil extends Thread {

	//que tan r�pido se mueve el proyectil
	protected int velocidadMovimiento;
	protected String direccionDibujo;
	protected JLabel dibujo;
	protected Posicion posActual;
	protected boolean vivo; //serviria para detectar cuando impact� la bala y matar el proyectil
							//pero dudo de su utilidad
	//el proyectil puede ir en cualquier direcci�n, eso daria a 8 sprrites distintos que varian en una rotaci�n del sprite inicial (Idle)
	protected ImageIcon[] sprite = new ImageIcon[8]; 
	
	/**
	 * metodo que le dice al proyectil donde debe viajar 
	 * @param pposicion a donde ir
	 * NOTA: Esto se hace en un contexto gr�fico
	 */
	public abstract void volarAPosicion(Posicion p);
	
	public void setPosicion(Posicion p) {
		posActual = p;
	}
}
