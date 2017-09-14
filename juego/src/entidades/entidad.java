package entidades;

import javax.swing.JLabel;

public abstract class entidad {

	protected String Nombre;
	protected JLabel Label;
	
	public entidad (String Nombre, JLabel Label) {
		this.Nombre = Nombre;
		this.Label = Label;
	}
	
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
	

	
	public JLabel getLabel () {
		return Label;
	}

}
