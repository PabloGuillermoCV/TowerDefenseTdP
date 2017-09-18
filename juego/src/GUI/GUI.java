package GUI;

import  Logica.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



public class GUI extends JFrame {
	private JFrame ventana;
	private MapaVisual mapa;
	private Nivel nivel;
	//private ContadorTiempo contadorTiempo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public GUI() {
		this.getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(517, 360);
		nivel= new Nivel(this);
		mapa = new MapaVisual(nivel.anchoMapa(),nivel.largoMapa(),nivel.getRutaMapa());
		this.getContentPane().add(mapa);
		this.add(mapa);
		
	}

	public MapaVisual getMapaVisual() {
		return mapa;
	}

}
