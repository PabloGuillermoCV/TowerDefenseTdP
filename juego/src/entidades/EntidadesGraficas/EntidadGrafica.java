package entidades.EntidadesGraficas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Posicion;

public abstract class EntidadGrafica { //En este paquete estarán todos los gráficos de las entidades
	
	protected JLabel grafico;
	protected Posicion pos;
	
	public EntidadGrafica (String File, Posicion pos) {
		this.grafico = new JLabel (new ImageIcon (this.getClass ().getResource (File)));
		this.pos = pos;
		this.grafico.setBounds (pos.getX (), pos.getY (), 20, 20);
		this.grafico.setVisible (true);
	}
	
	public abstract void moverA (Posicion pos, int vel);
	
	public JLabel getGrafico () {
		return grafico;
	}
	
	public Posicion getPosicion () {
		return pos;
	}
}