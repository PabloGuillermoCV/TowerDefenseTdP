package Logica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import GUI.TiendaVisual;

public class OyenteOleada implements ActionListener {

		private JButton ol;
		@SuppressWarnings("unused")
		private TiendaVisual juego;
		
		public OyenteOleada(JButton o, TiendaVisual instancia){
			ol = o;
			juego = instancia;
		}
		
		public void actionPerformed (ActionEvent E) {
			ol.setEnabled (false);
		}
}