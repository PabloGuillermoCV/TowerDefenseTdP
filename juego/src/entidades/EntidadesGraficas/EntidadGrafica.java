package entidades.EntidadesGraficas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.MapaVisual;
import Logica.Posicion;

public abstract class EntidadGrafica { //En este paquete estarán todos los gráficos de las entidades
	
	protected JLabel grafico;
	protected Posicion pos;
	protected MapaVisual mapaVisual;
	
	public EntidadGrafica (String File, Posicion pos) {
		this.grafico = new JLabel (new ImageIcon (File));
		this.pos = pos;
		this.mapaVisual = MapaVisual.InstanciaMapaVisual ();
		this.mapaVisual.getFondo().add (grafico);
		this.grafico.setBounds (pos.getX (), pos.getY (), 20, 20);
		this.grafico.setVisible (true);
	}
	
	public abstract void moverA (Posicion pos, int vel, int orientacion);
	public abstract void moverA (Posicion pos, int vel);
	
	public JLabel getGrafico () {
		return grafico;
	}
	
	public Posicion getPosicion () {
		return pos;
	}
	
	public void Morir () {
		this.grafico.setVisible (false);
	}
	
	/**
	 * Metodo que setea el gráfico del File
	 * @param File dirección del Sprite
	 */
	public void setFile(String File){
		grafico = new JLabel(new ImageIcon(File));
	}
}