package entidades;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Entidad {

	protected String Nombre;
	protected JLabel grafico;
	
	public Entidad (String Nombre, String File) {
		this.Nombre = Nombre;
		this.grafico = new JLabel (new ImageIcon (File));
		//this.grafico.setBounds(80, 60, 20, 20);
		this.grafico.setVisible(true);
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
	public JLabel getGrafico () {
		return grafico;
	}
	
	/**
	 * Metodo que cambia la imagen de la Entidad
	 * @param una direccion al archivo donde esta la imagen
	 */
	public void setGrafico (String File) {
		this.grafico = new JLabel (new ImageIcon ((File)));
	}
}