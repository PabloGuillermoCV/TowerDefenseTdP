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
	public String getNombre () {
		return Nombre;
	}
	
	public JLabel getLabel () {
		return Label;
	}
	
	public void iniciarAtaque() {
		
	}
}
