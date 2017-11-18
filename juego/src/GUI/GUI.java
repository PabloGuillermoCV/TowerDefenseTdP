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
	private JugadorI P;
	
	/**
	 * Launch the game Interface
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
		P = Jugador.InstanciaJugador ();
		
		this.getContentPane ().add (mapa);
		this.getContentPane ().add (shop);
		getContentPane().add (mapa);
		getContentPane().add (shop);
	
		nivel = new Nivel1 (this);
		mapa.getMapa ().setNivel (nivel);
		shop.setGUI (this);
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
	
	public JugadorI getJugador () {
		return P;
	}

	/**
	 * metodo que cambia el nivel
	 * @param n nivel a usar como nuevo nivel
	 */
	public void setNivel (Nivel n) {
		P.restablecerVidas ();
		nivel.getTienda().ActualizarValores();
		nivel = n;
		mapa.setVisible(false);
		mapa = nivel.getMapa().getMapaVisual();
		mapa.setVisible(true);
		mapa.getMapa ().setNivel (nivel);
		shop.setBotonOleadaOn ();
		shop.updateBotones(); 
		shop.setBotonesObjetosOff();
	}
	
	/**
	 * método para modificar el fondo del mapa
	 * @param dir dirección donde se encuentra la imagen a utilizar
	 */
	public void setGrafico (String dir) {
		mapa.updateFondo (dir);
	}
	
	/**
	 * método para notificarle al nivel de que envie una oleada de enemigos
	 */
	public void avisarNivel () {
		nivel.comenzarOleada ();
	}
	
	/**
	 * Metodo que se encarga de reestablecer todo a como estaba al inicio en el caso de perder
	 */
	public void reiniciarTodo () {
		P.setMonedas (1000);
		P.setPuntos (0);
		shop.getMarket ().ActualizarValores ();
		shop.updateBotones ();
		shop.setBotonesObjetosOff();
	}
}