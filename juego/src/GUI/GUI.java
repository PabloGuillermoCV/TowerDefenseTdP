package GUI;

import Logica.*;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.*;

@SuppressWarnings({"serial","unused"})
public class GUI extends JFrame {
	
	private static GUI Instancia;
	private JFrame ventana;
	private ContadorTiempo tiempo;
	private static int widthM = 500;
	private static int heightM = 320;
	private static int widthS = 500;
	private static int heightS = 400;
	private static String direccionM = "src\\GUI\\Sprites Mapas\\Mapa1.png";
	private static String direccionS = "src\\GUI\\Sprites Mapas\\FondoTiendaOff.png";
	private MapaVisual mapa;
	private TiendaVisual shop;
	private Nivel nivel;
	
	/**
	 * Launch the application.
	 */
	public static void main (String[] args) {
		EventQueue.invokeLater (new Runnable() {
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
	
	private GUI () {
		this.getContentPane ().setLayout (new GridLayout (2,1));
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		this.setSize (517, 800);
		mapa = MapaVisual.InstanciaMapaVisual ();
		shop = TiendaVisual.InstanciaTiendaVisual (widthS, heightS, direccionS);
		mapa.setGUI (this);
		
		this.getContentPane ().add (mapa);
		this.getContentPane ().add (shop);
		this.add (mapa);
		this.add (shop);
		
		nivel = new Nivel1 (this);
		
		tiempo = new ContadorTiempo (nivel);
		tiempo.start ();
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
	
	/*private void ver() {
		APie E = new APie(new Posicion (80,60));
		//E.getGrafico().setVisible(true);
		//this.getContentPane().add(E.getGrafico());
	}*/
}