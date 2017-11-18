package Creadores.CreadoresVisuales;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class FactoryVisual extends JButton {
	
	public FactoryVisual (String direccionIcono, String Nombre, int Costo, int alcance) {
		setLayout (new GridLayout ());
		setIcon (new ImageIcon (direccionIcono));
		setText (Nombre + " (M: " + Costo + ")");
		setSize (30, 20);
	}
}