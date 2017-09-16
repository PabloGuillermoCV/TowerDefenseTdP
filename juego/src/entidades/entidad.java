package entidades;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class entidad {

	protected String Nombre;
	protected JLabel Label;
	
	public entidad (String Nombre, String File) {
		this.Nombre = Nombre;
		this.Label = new JLabel (new ImageIcon (getClass ().getResource(File)));
	}
	
	/**
	 * Metodo que devuelve el nombre de la Entidad
	 * @return nombre de la Entidad
	 */
	public String getNombre() {
		return Nombre;
	}
	
	/**
	 * Metodo que devuelve el label (una imagen) de la Entidad
	 * @return una imagen de la Entidad
	 */
	public JLabel getLabel () {
		return Label;
	}
	
	/**
	 * Metodo que cambia la imagen de la Entidad
	 * @param una direccion al archivo donde esta la imagen
	 */
	public void setLabel (String File) {
		this.Label = new JLabel (new ImageIcon (getClass ().getResource(File)));
	}
}