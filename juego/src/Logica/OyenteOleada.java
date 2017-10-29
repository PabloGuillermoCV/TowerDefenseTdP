package Logica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import GUI.GUI;

public class OyenteOleada implements ActionListener {

		private  JButton ol;
		private GUI juego;
		
		public OyenteOleada(JButton o, GUI jue){
			ol = o;
			juego = jue;
		}
		@Override
		public void actionPerformed(ActionEvent E) {
			//juego.run();
			ol.setEnabled(false);
		}
		
}
