package GUI;
import javax.swing.ImageIcon;
//import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;


@SuppressWarnings("serial")
public class MapaVisual extends JPanel {
	private JLabel fondo;
	private int height;
	private int width;
	
	public MapaVisual(int width, int height,String direccion) {
		this.setLayout(null);
		this.setSize(width, height);
		this.height= height;
		this.width=width;
		ImageIcon imagen = new ImageIcon(direccion);
		cargarFondo(imagen);
		
		
	}

	public JLabel getFondo () {
		return fondo;
	}
	
	private void cargarFondo(ImageIcon im) {
		fondo = new JLabel(im);
		fondo.setBounds(0, 0, width, height);
		this.add(fondo);
	}

}
