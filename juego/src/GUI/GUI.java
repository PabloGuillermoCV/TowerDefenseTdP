package GUI;

import Logica.*;
import entidades.*;
import Enemigos.*;
import Controlables.*;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

@SuppressWarnings({ "serial", "unused" })
public class GUI extends JFrame {
	private JFrame ventana;
	private ContadorTiempo tiempo;
	private static int widthM = 500;
	private static int heightM = 320;
	private static int widthS = 500;
	private static int heightS = 400;
	private static String direccionM = "src\\GUI\\Sprites Mapas\\Mapa1.png";
	private static String direccionS = "src\\GUI\\Sprites Shop\\Shop.png";
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
	
	public GUI () { //comente los cambios que quiza usemos para agregar la tienda al frame
		this.getContentPane ().setLayout (new GridLayout (2,1));
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		this.setSize (517, 800);
		mapa = MapaVisual.InstanciaMapaVisual (widthM, heightM, direccionM,this);
		shop = TiendaVisual.InstanciaTiendaVisual (widthS, heightS, direccionS);
		nivel = new Nivel1 (this);
		this.getContentPane ().add (mapa);
		this.getContentPane ().add (shop);
		this.add (mapa);
		this.add (shop);
		tiempo = new ContadorTiempo (nivel);
		tiempo.start ();
		//ver();
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
	
	private void ver() {
		APie E = new APie(new Posicion (80,60));
		E.getGrafico().setVisible(true);
		this.getContentPane().add(E.getGrafico());
	}
}