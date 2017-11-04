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
import Objetos.ObjsDeLaTienda.ObjDeLaTienda;
import entidades.Objeto;

@SuppressWarnings("serial")
public class MapaVisual extends JPanel {
	
	private static MapaVisual Instancia;
	private GUI miGui;
	private JLabel fondo;
	private static int width = 500;
	private static int height = 320;
	private TiendaLogica marketL;
	private MapaLogico mapL;
	
	private MapaVisual () {
		this.setLayout (null);
		this.setSize (width, height);
		marketL = TiendaLogica.InstanciaTiendaLogica ();
		mapL = MapaLogico.InstanciaMapaLogico ();
		this.addMouseListener (new Mapa ());
	}
	
	public static MapaVisual InstanciaMapaVisual () {
		if (Instancia == null) {
			Instancia = new MapaVisual ();
		}
		return Instancia;
	}
	
	public void setGUI (GUI miGui) {
		this.miGui = miGui;
	}
	
	private class Mapa implements MouseListener {

		public void mouseClicked (MouseEvent E) {
			int X = E.getX ();
			int Y = E.getY ();
			System.out.println ("X: "+(X/20)*20+" Y: "+(Y/20)*20);
			Posicion P = new Posicion ((X / 20) * 20, (Y / 20) * 20); //Redondeo el valor a un multiplo de 20
			if (mapL.puedoAgregarControlable (P)) { //Si puedo poner un personaje y apreté el boton correcto
				Controlable Cont;
				Cont = marketL.createPersonaje (P);
				if (Cont != null) {
					mapL.agregarControlable (Cont, P);
					marketL.getP ().setMonedas(marketL.getP ().getMonedas () - Cont.getPrecio ()); 
					miGui.getTiendaVisual ().modificarMonedas ();
					miGui.getTiendaVisual ().updateBotones ();
				}
			}
			//No esta entrando al else de abajo
			else { //Sino verifico si apreté el botón correcto para objeto en un personaje
				if (mapL.puedoAgregarObjetoDeTienda (P)) {
					ObjDeLaTienda Obj;
					Obj = marketL.createObjeto (P);
					if (Obj != null) {
						marketL.getP ().setMonedas(marketL.getP ().getMonedas () - Obj.getPrecio ());
						miGui.getTiendaVisual ().modificarMonedas ();
						miGui.getTiendaVisual ().updateBotones ();
					}
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
	
	public void cargarFondo (String Direccion) {
		ImageIcon Imagen = new ImageIcon (Direccion);
		fondo = new JLabel (Imagen);
		fondo.setBounds (0, 0, width, height);
		this.add (fondo);
	}

	/**
	 * metodo que se encarga de agregar visualmente al mapa el objeto de mapa pasado por parametro
	 * @param k objeto a agregar
	 * @param p posición donde el objeto debe ser agregado
	 */
	public void agregarObjeto (Objeto k, Posicion p) {
		fondo.add (k.getGrafico ().getGrafico ());
		k.getGrafico ().getGrafico ().setBounds (p.getX (), p.getY (), 20, 20);
	}
}