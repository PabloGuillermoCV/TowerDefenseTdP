package entidades;
import java.awt.Graphics;
import javax.swing.JLabel;

public abstract class entidad {

	protected String nombre;
	protected Graphics label;
	protected JLabel getLabel;
	
	public entidad (String nombre, Graphics label, JLabel getLabel) {
		this.nombre = nombre;
		this.label = label;
		this.getLabel = getLabel;
	}
	
	/**
	 * metodo que devuelve el nombre de la Entidad
	 * @return nombre de la Entidad
	 */
	public abstract String getNombre();
	/**
	 * metodo que señala a la Entidad atacar a otra entidad
	 * @param e Entidad a atacar
	 */
	public abstract void atacar(entidad e);
	/**
	 * obtiene un Efecto para la Entidad
	 */
	public abstract void efecto();
	/**
	 * Elimina a la entidad del mapa
	 * @return la recompensa en oro
	 */
	public abstract int morir();
	/**
	 * vende la Entidad por oro
	 * @return valor en oro de la Entidad vendida
	 */
	public abstract int vender();
	/**
	 * cambia la posicion XY de la entidad
	 */
	public abstract void mover();
	/**
	 * Comanda el inicio de un ataque
	 */
	public abstract void iniciarAtaque();
}
