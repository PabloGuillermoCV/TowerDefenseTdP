package entidades;
import java.awt.Graphics;
import javax.swing.JLabel;

public abstract class entidad {

	protected String nombre;
	protected Graphics label;
	protected JLabel getLabel;
	
	/**
	 * metodo que devuelve el nombre de la Entidad
	 * @return nombre de la Entidad
	 */
	public abstract String getNombre();
	/**
	 * obteine el (Codigo?) de la Entidad
	 * @return
	 */
	public abstract int getCod();
	/**
	 * metodo que señala a la Entidad que ha sido atacada por algo (que luego resuelve el Visitor)
	 */
	public abstract void serAtacado(personaje p);
	/**
	 * obtiene un Efecto para la Entidad
	 */
	public abstract void efecto();
	
	public abstract void mover();
	
	public abstract int morir();
	
	public abstract int vender();
	
}
