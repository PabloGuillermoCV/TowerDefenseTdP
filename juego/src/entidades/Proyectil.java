package entidades;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Proyectil {

	//que tan r�pido se mueve el proyectil
	protected int velocidadMovimiento;
	protected String direccionDibujo;
	protected JLabel dibujo;
	//el proyectil puede ir en cualquier direcci�n, eso daria a 8 sprrites distintos que varian en una rotaci�n del sprite inicial (Idle)
	protected ImageIcon[] sprite = new ImageIcon[8]; 
	
	//usando el patr�n Strategy, este m�todo deberia despues ser llamado en alguna de las clases concretas de proyectil
	protected abstract void volarAEnemigo(enemigo E);
}
