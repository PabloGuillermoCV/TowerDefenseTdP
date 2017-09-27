package Creadores;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import Logica.*;
import entidades.Controlable;

@SuppressWarnings("serial")
public abstract class Factory extends JButton {
	
	public Factory (String direccionIcono, String Nombre, int Costo) {
		setLayout (new GridLayout ());
		setIcon (new ImageIcon (direccionIcono));
		setText (Nombre + Costo);
	}
	
	/**
	 * Crea una unidad del jugador en al posicion especificada
	 * @param C Posicion en donde insertar el personaje
	 * @return el nuevo personaje creado
	 * NOTA: Podriamos hacer que el descuento del Oro ocurra directamente aquí, pero tecnicamente NO tengo acceso a la Tienda aquí
	 */
	public abstract Controlable crear(Celda C);
}
