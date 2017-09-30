package Creadores.CreadoresVisuales;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class FactoryVisual extends JButton {
	
	public FactoryVisual (String direccionIcono, String Nombre, int Costo) {
		setLayout (new GridLayout ());
		setIcon (new ImageIcon (direccionIcono));
		setText (Nombre + Costo);
	}
}