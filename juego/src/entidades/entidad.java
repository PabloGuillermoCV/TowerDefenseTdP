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
<<<<<<< HEAD
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
	
=======
	public String getNombre () {
		return Nombre;
	}
	
	public JLabel getLabel () {
		return Label;
	}
	
	public void iniciarAtaque() {
		
	}
>>>>>>> e8b91c34bc6416b919ae85cd6a0df95cdd345ad1
}
