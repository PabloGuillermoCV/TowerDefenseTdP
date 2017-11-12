package Creadores.CreadoresVisuales;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class FactoryVisual extends JButton {
	
	public FactoryVisual (String direccionIcono, String Nombre, int Costo, int alcance) {
		setLayout (new GridLayout ());
		setIcon (new ImageIcon (direccionIcono));
		//Esta comentado por el momento porque no entra en el boton
		setText (Nombre + " (M: " + Costo + ")"/* +  "  \n(R: "  + alcance + ")" */);
		setSize (30, 20);
	}
}