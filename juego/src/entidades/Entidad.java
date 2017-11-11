package entidades;

import Logica.MapaLogico;
import Logica.Posicion;
import entidades.EntidadesGraficas.EntidadGrafica;

public abstract class Entidad {

	protected String Nombre;
	protected EntidadGrafica grafico;
	protected Posicion pos;
	protected MapaLogico miMapa;
	
	public Entidad (String Nombre, Posicion pos) {
		this.Nombre = Nombre;
		this.pos = pos;
		this.miMapa = MapaLogico.InstanciaMapaLogico ();
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
	
	public MapaLogico getMapa () {
		return miMapa;
	}
	
	public Posicion getPos () {
		return pos;
	}
	
	public void setPos (Posicion P) {
		this.pos = P;
		this.grafico.getGrafico().setBounds (getPos ().getX (), getPos ().getY (), 20, 20);
	}
}