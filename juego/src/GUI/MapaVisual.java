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
		marketL.setTiendaVisual (marketV);
	}
	
	public static MapaVisual InstanciaMapaVisual () {
		if (Instancia == null) {
			Instancia = new MapaVisual ();
		}
		return Instancia;
	}
	
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
						//Al hacer doble click vendo al personaje (si no agarre un power up)
						venderControlable (C);
					}
					else {
						//Si no, le doy un Power Up al personaje
						darPowerUp (C);
					}
				}
				else {
					if (C.getObjeto () != null) {
						//Hago click en un Power Up y lo levanto
						agarrarPowerUp (C);
					}
				}
			}
			else {
				//Hice un solo click
				if (mapL.puedoAgregarControlable (P)) {
					//Agrego un controlable a un espacio vacio
					agregarControlable (P);
				}
				else {
					//Agrego un objeto de la tienda
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
	
	public TiendaLogica getTiendaL () {
		return marketL;
	}
	
	public TiendaVisual getTiendaV () {
		return marketV;
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
			marketL.EliminarCreador ();
			marketL.getP ().setMonedas (marketL.getP ().getMonedas () - Cont.getPrecio ());
			marketV.modificarMonedas ();
			marketV.updateBotones ();
		}
	}
	
	private void agregarObjetoTienda (Posicion P) {
		//Condicion: un click en el mapa despues de seleccionar un objeto de la tienda
		if (mapL.puedoAgregarObjetoDeTienda (P)) {
			Celda C = mapL.getCelda (P.getX (), P.getY ());
			ObjDeLaTienda Obj;
			Obj = marketL.createObjeto (P);
			if (Obj != null) {
				marketL.getP ().setMonedas (marketL.getP ().getMonedas () - Obj.getPrecio ());
				marketV.modificarMonedas ();
				marketV.updateBotones ();
				if (C.getPersonaje () != null) {
					Obj.Afectar (C.getPersonaje ());
				}
				else {
					Obj.Afectar ();
				}
				marketV.modificarMonedas ();
				marketV.updateBotones ();
			}
		}
	}
	
	private void venderControlable (Celda C) {
		//Condicion: doble click en un controlable sin nada "en la mano"
		Controlable Cont = C.getPersonaje ();
		if (Cont.getEstado ().getVida () >= Cont.getVidaMax ()) {
			//El personaje no esta herido y lo vendo al precio original
			marketL.getP ().setMonedas(marketL.getP ().getMonedas () + Cont.getPrecio ()); 
		}
		else {
			//El personaje esta herido y lo vendo a la mitad
			marketL.getP ().setMonedas(marketL.getP ().getMonedas () + (Cont.getPrecio () / 2));
		}
		//mapL.eliminarControlable(Cont); //Le digo al mapa logico que este controlable ya no existe
		Cont.morir ();
		marketV.modificarMonedas ();
		marketV.updateBotones ();
	}
	
	private void agarrarPowerUp (Celda C) {
		//Condicion: doble click en un objeto power up
		tengoPU = C.getObjeto ().Agarrar (); //Saca el objeto del mapa
		if (tengoPU != null) {
			//Si no es nulo, lo saco y me lo quedo
			//C.EliminarObjetoDeCelda (C.getObjeto ());
			marketV.setBotonesOff ();
		}
	}
	
	private void darPowerUp (Celda C) {
		//Condicion: doble click en un controlable con un power up "en la mano"
		Controlable Cont = C.getPersonaje ();
		tengoPU.Afectar (Cont); //Le da el PU al personaje
		marketV.setBotonesOn ();
		marketV.updateBotones ();
		tengoPU = null;
	}
}