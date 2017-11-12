package GUI;

import Logica.Jugador;
import Logica.TiendaLogica;
import Audio.Sonido;
import Creadores.CreadoresLogicos.*;
import Creadores.CreadoresVisuales.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TiendaVisual extends JPanel {
	
	private static TiendaVisual Instancia;
	private JPanel panelBotones;
	private JPanel panelDisplay;
	private static int width = 500;
	private static int height = 400;
	private FactoryVisual [] botones = new FactoryVisual [8];
	private FactoryLogica [] creadores = new FactoryLogica [8];
	private Sonido efectos;
	private Jugador P;
	private JLabel displayMonedas;
	private JLabel displayPuntos;
	private JButton oleada;
	private TiendaLogica market;
	private GUI miGUI;
	
	private TiendaVisual () {
		this.setLayout (new BoxLayout (this, BoxLayout.Y_AXIS));
		this.setBorder (BorderFactory.createLineBorder (Color.DARK_GRAY, 2));
		this.setSize (width, height);
		this.efectos = new Sonido ();
		this.market = TiendaLogica.InstanciaTiendaLogica ();
		P = Jugador.InstanciaJugador ();
		
		setDisplay ();
		setCreadores ();
		setBotones ();
		setBotonesObjetosOff ();
	}
	
	public static TiendaVisual InstanciaTiendaVisual () {
		if (Instancia == null) {
			Instancia = new TiendaVisual ();
		}
		return Instancia;
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
	
	public Sonido getAudio () {
		return efectos;
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
	
	public GUI getGUI () {
		return miGUI;
	}
	
	public void setGUI (GUI miGUI) {
		this.miGUI = miGUI;
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
        
        panelBotones = new JPanel ();
		panelBotones.setLayout (new GridLayout (4,2,2,2));
        
		for (int i = 0; i < 8; i++) {
        	botones [i].setPreferredSize (new Dimension (10,10));
    		panelBotones.add (botones [i]);
    	}
		panelBotones.setPreferredSize (new Dimension (100,250));
        this.add (panelBotones);
        
        updateBotones ();
	}
	
	public void setBotonesOn () {
		for (int i = 0; i < 8; i++) {
    		botones [i].setEnabled (true);
    	}
	}
	
	public void setBotonesOff () {
		for (int i = 0; i < 8; i++) {
    		botones [i].setEnabled (false);
    	}
	}
	
	public void setBotonesObjetosOff () {
		//Se llama cuando no hay personajes aliados en el mapa
		for (int i = 5; i < 8; i++) {
    		botones [i].setEnabled (false);
    	}
	}
	
	public void setBotonOleadaOn () {
		oleada.setEnabled (true);
	}
	
	public void setBotonOleadaOff () {
		oleada.setEnabled (false);
	}
	
	/**
	 * Prende y apaga los botones despues de cada compra dependiendo de las monedas restantes
	 */
	public void updateBotones () {
		int Precio;
		for (int I = 0; I < 8; I++) {
			Precio = creadores [I].getCosto ();
			if (Precio > P.getMonedas ()) {
				botones [I].setEnabled (false);
			}
			else {
				botones [I].setEnabled (true);
			}
		}
	}
	/**
	 * método que construye la interfaz gráfica de la Tienda Visual
	 * usa un FLow Layout justificando las componenetes a izquierda
	 */
	public void setDisplay () {
		panelDisplay = new JPanel ();
		panelDisplay.setLayout (new FlowLayout (FlowLayout.LEFT));
		
		displayMonedas = new JLabel ("Monedas: " + P.getMonedas ());
		displayPuntos = new JLabel ("Puntos: " + P.getPuntos ());
		
		oleada = new JButton ("Empezar Oleada");
		oleada.addActionListener (new OyenteBotonOleada ());
		
		panelDisplay.add (displayMonedas);
		panelDisplay.add (displayPuntos);
		panelDisplay.add (oleada);
		panelDisplay.setBorder (BorderFactory.createLineBorder (Color.DARK_GRAY, 2));
		panelDisplay.setPreferredSize (new Dimension (10,10));
		this.add (panelDisplay);
	}
	
	public void modificarMonedas () {
		displayMonedas.setText ("Monedas: " + P.getMonedas ());
	}
	
	public void modificarPuntaje () {
		displayPuntos.setText ("Puntos: " + P.getPuntos ());
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
	
	private class OyenteBotonOleada implements ActionListener {
		public void actionPerformed (ActionEvent E) {
			oleada.setEnabled (false);
			miGUI.avisarNivel ();
		}
	}
}