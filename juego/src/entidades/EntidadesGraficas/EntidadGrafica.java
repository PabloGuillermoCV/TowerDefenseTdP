package entidades.EntidadesGraficas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class EntidadGrafica { //En este paquete estarán todos los gráficos de las entidades
	
	protected JLabel grafico;
	
	public EntidadGrafica (String File) {
		this.grafico = new JLabel (new ImageIcon (File));
		this.grafico.setVisible(true);
	}
}