package GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Logica.Celda;
import Logica.MapaLogico;
import Logica.Posicion;
import Logica.TiendaLogica;
import entidades.Controlable;
import Objetos.ObjsDeLaTienda.ObjDeLaTienda;
import entidades.Objeto;

@SuppressWarnings("serial")
public class MapaVisual extends JPanel {
	
	private static MapaVisual Instancia;
	//private GUI miGui;
	private JLabel fondo;
	private static int width = 500;
	private static int height = 320;
	private TiendaLogica marketL;
	private MapaLogico mapL;
	private TiendaVisual marketV;
	private Objeto tengoPU;
	
	private MapaVisual () {
		this.setLayout (null);
		this.setSize (width, height);
		marketL = TiendaLogica.InstanciaTiendaLogica ();
		mapL = MapaLogico.InstanciaMapaLogico ();
		marketV = TiendaVisual.InstanciaTiendaVisual ();
		this.addMouseListener (new Mapa ());
	}
	
	public static MapaVisual InstanciaMapaVisual () {
		if (Instancia == null) {
			Instancia = new MapaVisual ();
		}
		return Instancia;
	}
	
	/*public void setGUI (GUI miGui) {
		this.miGui = miGui;
	}*/
	
	private class Mapa implements MouseListener {

		public void mouseClicked (MouseEvent E) {
			int X = E.getX ();
			int Y = E.getY ();
			//Redondeo el valor a un multiplo de 20
			Posicion P = new Posicion ((X / 20) * 20, (Y / 20) * 20);
			if (E.getClickCount () == 2 && !E.isConsumed ()) {
				//Hice dos clicks
				Celda C = mapL.getCelda (P.getX (), P.getY ());
				if (C.getPersonaje () != null) {
					if (tengoPU == null) {
						venderControlable (C); //si NO tengop un PowerUp para consumir y estoy haciendo doble click, vendo al controlable asuminedo que hay uno
					}
					else {
						darPowerUp (C); //sino, le doy el powerup a ese personaje
					}
				}
				else {
					if (C.getObjeto () != null) {//si hago doble click sobre un objeto, lo levanto
						agarrarPowerUp (C);
					}
				}
			}
			else {
				//Hice un solo click
				if (mapL.puedoAgregarControlable (P)) { //agrego controlables
					agregarControlable (P);
				}
				else {
					agregarObjetoTienda (P);
				}
			}
		}
		public void mouseEntered(MouseEvent E) {}
		public void mouseExited(MouseEvent E) {}
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
	
	public MapaLogico getMapa () {
		return mapL;
	}
	
	public void cargarFondo () {
		ImageIcon Imagen = new ImageIcon ("");
		fondo = new JLabel (Imagen);
		fondo.setBounds (0, 0, width, height);
		this.add (fondo);
	}
	
	public void updateFondo (String Direccion) {
		fondo.setIcon (new ImageIcon (Direccion));
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
	
	//Metodos usados por el mouse listener
	
	private void agregarControlable (Posicion P) {
		//Condicion: un click en el mapa despues de seleccionar un personaje de la tienda
		Controlable Cont;
		Cont = marketL.createPersonaje (P);
		if (Cont != null) {
			mapL.agregarControlable (Cont, P);
			marketL.getP ().setMonedas (marketL.getP ().getMonedas () - Cont.getPrecio ());
			marketV.modificarMonedas ();
			marketV.updateBotones ();
			marketV.setBotonOleadaOn ();
		}
	}
	
	private void agregarObjetoTienda (Posicion P) {
		//Condicion: un click en el mapa despues de seleccionar un objeto de la tienda
		if (mapL.puedoAgregarObjetoDeTienda (P)) {
			ObjDeLaTienda Obj;
			Obj = marketL.createObjeto (P);
			if (Obj != null) {
				marketL.getP ().setMonedas (marketL.getP ().getMonedas () - Obj.getPrecio ());
				marketV.modificarMonedas ();
				marketV.updateBotones ();
				marketV.setBotonOleadaOn ();
			}
		}
	}
	
	private void venderControlable (Celda C) {
		//Condicion: doble click en un controlable sin nada "en la mano"
		Controlable Cont = C.getPersonaje ();
		if (Cont.getEstado ().getVida () < Cont.getVidaMax ()) { //si el personaje está herido, el precio de reventa se reduce a la mitad
			marketL.getP ().setMonedas(marketL.getP ().getMonedas () + (Cont.getPrecio () / 2)); 
		}
		else {
			marketL.getP ().setMonedas(marketL.getP ().getMonedas () + Cont.getPrecio ()); //sino , la reventa se hace por el precio original de venta
		}
		
		//Hay que sacar al personaje del hilo
		//Es un problema parecido al que tenemos con enemigo
		
		mapL.eliminarControlable(Cont); //le digo al mapa Logico que este controlable ya no existe
		Cont.morir ();
		marketV.modificarMonedas ();
		marketV.updateBotones ();
	}
	
	private void agarrarPowerUp (Celda C) {
		//Condicion: doble click en un objeto power up
		tengoPU.Agarrar (); //Saca el objeto del mapa
		if (tengoPU != null) {
			marketV.setBotonesOff ();
			marketV.setBotonOleadaOff ();
		}
	}
	
	private void darPowerUp (Celda C) {
		//Condicion: doble click en un controlable con un power up "en la mano"
		Controlable Cont = C.getPersonaje ();
		tengoPU.Afectar (Cont); //Le da el PU al personaje
		marketV.setBotonesOn ();
		marketV.setBotonOleadaOn ();
		tengoPU = null;
	}
}