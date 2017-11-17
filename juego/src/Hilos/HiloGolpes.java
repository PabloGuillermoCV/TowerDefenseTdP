package Hilos;


import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import GUI.MapaVisual;
import Logica.Posicion;

public class HiloGolpes extends Thread {
	
	private MapaVisual miMapa;
	private JLabel GIF;
	private volatile LinkedList <Posicion> miLista;
	private volatile LinkedList <Posicion> miListaParaAgregar;
	public HiloGolpes () {
		GIF = new JLabel (new ImageIcon ("src\\entidades\\Disparos\\Sprites Disparos\\Animacion Golpe.gif"));
		miMapa = MapaVisual.InstanciaMapaVisual ();
		miLista = new LinkedList <Posicion> ();
		miListaParaAgregar = new LinkedList<Posicion>();
	}
	
	public void run () {
		while (true) {
			if (!miLista.isEmpty ()) {
				while (!miLista.isEmpty ()) {
					Posicion P = miLista.removeFirst();
					miMapa.getFondo ().add (GIF);
					GIF.setBounds(P.getX(), P.getY(), 20, 20);
					GIF.setVisible(true);
					try {
						HiloGolpes.sleep(350);
						GIF.setVisible(false);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
			}
			else {
				try {
					cambiarLista();
					HiloGolpes.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}
	}
	private synchronized void cambiarLista() {
		while(!miListaParaAgregar.isEmpty())
			miLista.add(miListaParaAgregar.removeFirst());
	}
	
	public void agregarALista(Posicion P) {
		miListaParaAgregar.addLast(P);
	}


}