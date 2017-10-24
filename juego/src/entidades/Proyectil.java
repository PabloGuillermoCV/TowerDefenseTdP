package entidades;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Posicion;

public abstract class Proyectil extends Thread {

	//que tan rápido se mueve el proyectil
	protected int velocidadMovimiento;
	protected String direccionDibujo;
	protected JLabel dibujo;
	protected Posicion posActual;
	protected boolean vivo; //serviria para detectar cuando impactó la bala y matar el proyectil
							//pero dudo de su utilidad
	//el proyectil puede ir en cualquier dirección, eso daria a 8 sprrites distintos que varian en una rotación del sprite inicial (Idle)
	protected ImageIcon[] sprite = new ImageIcon[8]; 
	
	/**
	 * metodo que le dice al proyectil donde debe viajar 
	 * @param pposicion a donde ir
	 * NOTA: Esto se hace en un contexto gráfico
	 */
	public abstract void volarAPosicion(Posicion p);
	
	public void setPosicion(Posicion p) {
		posActual = p;
	}
}
