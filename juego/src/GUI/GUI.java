package GUI;

import Logica.*;
import Logica.Niveles.*;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.*;

@SuppressWarnings("serial")
public class GUI extends JFrame {
	
	private static GUI Instancia;
	private JFrame ventana;
	private MapaVisual mapa;
	private TiendaVisual shop;
	private Nivel nivel;
	private Jugador P;
	
	/**
	 * Launch the application.
	 */
	public static void main (String[] args) {
		EventQueue.invokeLater (new Runnable() {
			public void run () {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private GUI () {
		this.getContentPane ().setLayout (new GridLayout (2,1));
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		this.setSize (516, 680);
		mapa = MapaVisual.InstanciaMapaVisual ();
		mapa.cargarFondo ();
		shop = TiendaVisual.InstanciaTiendaVisual ();
		shop.cargarFondo ();
		mapa.setGUI (this);
		P = Jugador.InstanciaJugador ();
		
		this.getContentPane ().add (mapa);
		this.getContentPane ().add (shop);
		getContentPane().add (mapa);
		getContentPane().add (shop);
	
		nivel = new Nivel1 (this);
	}
	
	public static GUI InstanciaGUI () {
		if (Instancia == null) {
			Instancia = new GUI ();
		}
		return Instancia;
	}
	
	public MapaVisual getMapaVisual() {
		return mapa;
	}
	
	public TiendaVisual getTiendaVisual () {
		return shop;
	}
	
	public Nivel getNivel () {
		return nivel;
	}
	
	public JFrame getVentana () {
		return ventana;
	}
	
	public Jugador getJugador () {
		return P;
	}

	/**
	 * metodo que cambia el nivel (en lógica, más o menos?)
	 * @param n nivel a usar como nuevo nivel
	 */
	public void setNivel (Nivel n) {
		P.reestablecerVidas ();
		nivel = n;
		mapa.setVisible(false);
		mapa = nivel.getMapa().getMapaVisual();
		mapa.setVisible(true);
	}
	
	public void setGrafico (String dir) {
		mapa.updateFondo (dir);
	}
}