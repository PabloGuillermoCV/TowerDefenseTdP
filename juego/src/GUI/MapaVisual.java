package GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MapaVisual extends JPanel{
	private JLabel fondo;
	private int height;
	private int width;
	
	public MapaVisual (int width, int height, String direccion) {
		this.setLayout (null);
		this.setSize (width, height);
		this.height = height;
		this.width = width;
		ImageIcon imagen = new ImageIcon (direccion);
		cargarFondo (imagen);
		//this.addMouseListener(new Tendero);
	}

	@SuppressWarnings("unused")
	private class Tendero implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		
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