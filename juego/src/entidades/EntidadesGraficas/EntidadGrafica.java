package entidades.EntidadesGraficas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class EntidadGrafica { //En este paquete estar�n todos los gr�ficos de las entidades
	
	protected JLabel grafico;
	
	public EntidadGrafica (String File) {
		this.grafico = new JLabel (new ImageIcon (File));
		this.grafico.setVisible(true);
	}
}