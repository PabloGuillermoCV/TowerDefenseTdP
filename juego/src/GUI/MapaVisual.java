package GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Logica.MapaLogico;
import Logica.Posicion;
import Logica.TiendaLogica;
import entidades.Controlable;

@SuppressWarnings("serial")
public class MapaVisual extends JPanel {
	
	private static MapaVisual Instancia;
	private GUI miGui;
	private JLabel fondo;
	private int height;
	private int width;
	private TiendaLogica marketL;
	private MapaLogico mapL;
	
	
	private MapaVisual (int width, int height, String direccion) {
		this.setLayout (null);
		this.setSize (width, height);
		this.height = height;
		this.width = width;
		marketL = TiendaLogica.InstanciaTiendaLogica ();
		mapL = MapaLogico.InstanciaMapaLogico ();
		ImageIcon imagen = new ImageIcon (direccion);
		cargarFondo (imagen);
		this.addMouseListener (new Tendero ());
	}
	
	public static MapaVisual InstanciaMapaVisual () {
		if (Instancia == null) {
			Instancia = new MapaVisual (500, 320, "src\\GUI\\Sprites Mapas\\Mapa1.png");
		}
		return Instancia;
	}
	
	public void setGUI (GUI miGui) {
		this.miGui = miGui;
	}
	
	private class Tendero implements MouseListener {

		public void mouseClicked (MouseEvent E) {
			int X = E.getX ();
			int Y = E.getY ();
			Posicion P = new Posicion (X,Y);
			Controlable Ent;
			if (mapL.puedoAgregarControlable (P)) {
				Ent = marketL.createPersonaje (P);
				if (Ent != null) {
					marketL.getP().setMonedas(marketL.getP ().getMonedas () - Ent.getPrecio ()); 
					miGui.getTiendaVisual ().modificarMonedas ();
					miGui.getTiendaVisual ().updateBotones ();
				}
			}
		}
		
		/**
		 * metodo que cuando detecta el mouse el creador NO es nulo, resalta la celda 
		 * donde esta posado el mouse
		 * Problema: NO pinta el recuadro, creo que tengo el problema que teniamos con los personajes
		 */
		public void mouseEntered(MouseEvent E) {
			if(marketL.getCreator() != null){
				int X = E.getX();
				int Y = E.getY();
				ImageIcon cuadro = new ImageIcon("RecuadroCeldas.png");
				cuadro.paintIcon(fondo, fondo.getGraphics(), X, Y);
			}
		}
		/**
		 * metodo que detecta si el mouse sali� de una celda y su creador NO era Nulo, 
		 * elimina el recuadro creado anteriormente por mouseEntered
		 */
		public void mouseExited(MouseEvent E) {
			if(marketL.getCreator() != null){}
		}
		public void mousePressed(MouseEvent E) {}
		public void mouseReleased(MouseEvent E) {}
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
	
	private void cargarFondo (ImageIcon im) {
		fondo = new JLabel (im);
		fondo.setBounds (0, 0, width, height);
		this.add (fondo);
	}
}