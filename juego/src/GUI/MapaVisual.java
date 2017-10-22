package GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
	
	
	private MapaVisual (int width, int height, String direccion, GUI gui) {
		miGui=gui;
		this.setLayout (null);
		this.setSize (width, height);
		this.height = height;
		this.width = width;
		marketL = TiendaLogica.InstanciaTiendaLogica ();
		ImageIcon imagen = new ImageIcon (direccion);
		cargarFondo (imagen);
		this.addMouseListener (new Tendero ());
	}
	
	public static MapaVisual InstanciaMapaVisual (int width, int height, String direccion,GUI gui) {
		if (Instancia == null) {
			Instancia = new MapaVisual (width, height, direccion, gui);
		}
		return Instancia;
	}
	
	private class Tendero implements MouseListener {

		public void mouseClicked (MouseEvent E) {
			int X = E.getX ();
			int Y = E.getY ();
			Posicion P = new Posicion (X,Y);
			Controlable Ent;
			Ent = marketL.createPersonaje (P);
			
			if (Ent != null) {
				fondo.add (Ent.getGrafico ().getGrafico ());
				Ent.setPos (P);
				miGui.getNivel().getMapa().agregarControlable(Ent, P);
				miGui.getTiendaVisual().setBotonesOn ();
				
				marketL.getP().setMonedas(marketL.getP().getMonedas() - 100); 
				miGui.getTiendaVisual().modificarMonedas();
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
		 * metodo que detecta si el mouse salió de una celda y su creador NO era Nulo, 
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