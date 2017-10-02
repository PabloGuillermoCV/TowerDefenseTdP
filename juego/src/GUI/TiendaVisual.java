package GUI;

import Logica.Jugador;
import Logica.TiendaLogica;
import Audio.Sonido;
import Creadores.CreadoresLogicos.*;
import Creadores.CreadoresVisuales.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings({ "serial", "unused" })
public class TiendaVisual extends JPanel {
	private JLabel fondo;
	private int height;
	private int width;
	private FactoryVisual [] botones = new FactoryVisual [8];
	private FactoryLogica [] creadores = new FactoryLogica [8];
	private Sonido efectos;
	private Jugador P;
	private JLabel displayMonedas;
	private JLabel displayPuntos;
	private TiendaLogica market;
	
	public TiendaVisual (int width, int height, String direccion) {
		this.setLayout (new FlowLayout ());
		this.setSize (width, height);
		this.height = height;
		this.width = width;
		this.efectos = new Sonido ();
		this.market = new TiendaLogica ();
		ImageIcon imagen = new ImageIcon (direccion);
		cargarFondo (imagen);
		P = new Jugador ();
		setNumeros ();
		setCreadores ();
		setBotones ();
	}
	
	public JLabel getFondo () {
		return fondo;
	}
	
	public int getHeight () {
		return height;
	}
	
	public int getWidth () {
		return width;
	}
	
	public FactoryVisual [] getBotones () {
		return botones;
	}
	
	public Jugador getP () {
		return P;
	}
	
	public JLabel getPanelMonedas () {
		return displayMonedas;
	}
	
	public JLabel getPanelPuntos () {
		return displayPuntos;
	}
	
	public TiendaLogica getMarket () {
		return market;
	}
	
	private void cargarFondo(ImageIcon im) {
		fondo = new JLabel(im);
		fondo.setBounds(0, 0, width, height);
		this.add(fondo);
	}
	
	private void setCreadores () {
		creadores [0] = new CreadorSoldadoLogico ();
		creadores [1] = new CreadorArqueroLogico ();
		creadores [2] = new CreadorCaballeroLogico ();
		creadores [3] = new CreadorCatapultaLogica ();
		creadores [4] = new CreadorEliteLogico ();
		creadores [5] = new CreadorExplosivoLogico ();
		creadores [6] = new CreadorKitMedicoLogico ();
		creadores [7] = new CreadorArmaduraLogica ();
	}
	
	private void setBotones () {
        botones [0] = new BotonSoldado ();
        OyenteBotonSoldado O0 = new OyenteBotonSoldado ();
        botones [0].addActionListener (O0);
        
        botones [1] = new BotonArquero ();
        OyenteBotonArquero O1 = new OyenteBotonArquero ();
        botones [1].addActionListener (O1);
        
        botones [2] = new BotonCaballero ();
        OyenteBotonCaballero O2 = new OyenteBotonCaballero ();
        botones [2].addActionListener (O2);
        
        botones [3] = new BotonCatapulta ();
        OyenteBotonCatapulta O3 = new OyenteBotonCatapulta ();
        botones [3].addActionListener (O3);
        
        botones [4] = new BotonElite ();
        OyenteBotonElite O4 = new OyenteBotonElite ();
        botones [4].addActionListener (O4);
        
        botones [5] = new BotonExplosivo ();
        OyenteBotonExplosivo O5 = new OyenteBotonExplosivo ();
        botones [5].addActionListener (O5);
        
        botones [6] = new BotonKitMedico ();
        OyenteBotonKitMedico O6 = new OyenteBotonKitMedico ();
        botones [6].addActionListener (O6);
        
        botones [7] = new BotonArmadura ();
        OyenteBotonArmadura O7 = new OyenteBotonArmadura ();
        botones [7].addActionListener (O7);
        
        for (int i = 0; i < 8; i++) {
    		add (botones [i]);
    	}
	}
	
	private void setBotonesOff () {
		for (int i = 0; i < 8; i++) {
    		botones [i].setEnabled (false);
    	}
	}
	
	public void setBotonesOn () {
		for (int i = 0; i < 8; i++) {
    		botones [i].setEnabled (true);
    	}
	}
	
	public void setNumeros () {
		displayMonedas = new JLabel ("Monedas: " + P.getMonedas ());
		displayPuntos = new JLabel ("Puntos: " + P.getPuntos ());
		add (displayMonedas);
		add (displayPuntos);
	}
	
	public void modificarMonedas () {
		displayMonedas.setText ("Monedas: " + P.getMonedas ());
	}
	
	public void modificarPuntaje () {
		displayMonedas.setText ("Puntos: " + P.getPuntos ());
	}
	
	private class OyenteBotonSoldado implements ActionListener {
		public void actionPerformed (ActionEvent E) {
			market.setCreador (creadores [0]);
			setBotonesOff ();
		}
	}
	
	private class OyenteBotonArquero implements ActionListener {
		public void actionPerformed (ActionEvent E) {
			market.setCreador (creadores [1]);
			setBotonesOff ();
		}
	}
	
	private class OyenteBotonCaballero implements ActionListener {
		public void actionPerformed (ActionEvent E) {
			market.setCreador (creadores [2]);
			setBotonesOff ();
		}
	}
	
	private class OyenteBotonCatapulta implements ActionListener {
		public void actionPerformed (ActionEvent E) {
			market.setCreador (creadores [3]);
			setBotonesOff ();
		}
	}
	
	private class OyenteBotonElite implements ActionListener {
		public void actionPerformed (ActionEvent E) {
			market.setCreador (creadores [4]);
			setBotonesOff ();
		}
	}
	
	private class OyenteBotonExplosivo implements ActionListener {
		public void actionPerformed (ActionEvent E) {
			market.setCreador (creadores [5]);
			setBotonesOff ();
		}
	}
	
	private class OyenteBotonKitMedico implements ActionListener {
		public void actionPerformed (ActionEvent E) {
			market.setCreador (creadores [6]);
			setBotonesOff ();
		}
	}
	
	private class OyenteBotonArmadura implements ActionListener {
		public void actionPerformed (ActionEvent E) {
			market.setCreador (creadores [7]);
			setBotonesOff ();
		}
	}
}