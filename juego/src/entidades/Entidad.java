package entidades;

import Logica.Posicion;
import entidades.EntidadesGraficas.EntidadGrafica;

public abstract class Entidad {

	protected String Nombre;
	protected EntidadGrafica grafico;
	protected Posicion pos;
	
	public Entidad (String Nombre, Posicion pos) {
		this.Nombre = Nombre;
		this.pos = pos;
		System.out.println("X "+pos.getX()+"Y "+pos.getY());
		
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
	public EntidadGrafica getGrafico () {
		return grafico;
	}
	
	/**
	 * Metodo que cambia la imagen de la Entidad
	 * @param una direccion al archivo donde esta la imagen
	 */
	/*public void setGrafico (String File) {
		this.grafico = new JLabel (new ImageIcon ((File)));
	}*/
	
	public Posicion getPos () {
		return pos;
	}
	
	public void setPos (Posicion P) {
		this.pos = P;
		this.grafico.getGrafico().setBounds (getPos ().getX (), getPos ().getY (), 20, 20);
	}
}