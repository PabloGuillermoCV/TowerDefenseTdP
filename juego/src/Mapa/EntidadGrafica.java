package Mapa;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class EntidadGrafica {
	private JLabel grafico;
	private String dir= "C:\\Users\\Franco Sacomani\\Desktop\\Tower Defense\\recorte.png";
	private Posicion pos;
	
	
	public EntidadGrafica(Posicion pos) {
		this.pos=pos;
		ImageIcon imagen = new ImageIcon(dir);
		grafico= new JLabel(imagen);
		this.grafico.setBounds(pos.getX(), pos.getY(), 20, 20);
	}
	
	public void moverA(Posicion pos) {
		try {
		if(this.pos.getX()!= pos.getX()) {
			while(this.pos.getX()!=pos.getX())
				this.grafico.setBounds(this.pos.getX()-5, this.pos.getY(),20, 20);
			    Thread.sleep(100);
		}
		else {
			while(this.pos.getY()!=pos.getY()) {
				this.grafico.setBounds(this.pos.getX(), this.pos.getY()-5,20, 20);
			    Thread.sleep(100);
			}
		}		
		this.pos=pos;
		}
		
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
}
	public JLabel getGrafico() {
		return grafico;
	}

}