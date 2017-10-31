package entidades.EntidadesGraficas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Logica.Posicion;

public class EntidadGraficaAtaque extends EntidadGrafica {
	
	protected ImageIcon [] OrientacionSprite = new ImageIcon [8];
	
	public EntidadGraficaAtaque (String [] File, Posicion pos) {
		super (File [0], pos);
		for (int I = 0; I < 8; I++) {
			OrientacionSprite [I] = new ImageIcon (File [I]);
		}
		this.setFile(File[0]);
	}

	public void moverA(Posicion pos, int vel, int orientacion) {
		grafico = new JLabel (OrientacionSprite [orientacion]);
		while (this.pos.getX() != pos.getX() || this.pos.getY() != pos.getY()){
			System.out.println("Estoy volando graficamente");
			try {
				//como como me muevo depende de la orientacion del proyectil y hay 8 direcciones posibles, es mejor un switch que 8 ifs seguidos
				switch(orientacion){
					case 0:
						this.grafico.setBounds(this.pos.getX() + vel, this.pos.getY(), 20, 20);
						this.pos.setX(this.pos.getX() + vel);
						Thread.sleep(100);
						break;
					case 1:
						this.grafico.setBounds(this.pos.getX() + vel, this.pos.getY() + vel,20,20);
						this.pos.setX(this.pos.getX() + vel);
						this.pos.setY(this.pos.getY() + vel);
						Thread.sleep(100);
						break;
					case 2:
						this.grafico.setBounds(this.pos.getX(), this.pos.getY() + vel, 20,20);
						this.pos.setY(this.pos.getY() + vel);
						Thread.sleep(100);
						break;
					case 3:
						this.grafico.setBounds(this.pos.getX() - vel, this.pos.getY() + vel, 20,20);
						this.pos.setX(this.pos.getX() - vel);
						this.pos.setY(this.pos.getY() + vel);
						Thread.sleep(100);
						break;
					case 4:
						this.grafico.setBounds(this.pos.getX() - vel, this.pos.getY(),20,20);
						this.pos.setX(this.pos.getX() - vel);
						Thread.sleep(100);
						break;
					case 5:
						this.grafico.setBounds(this.pos.getX()-vel, this.pos.getY()-vel,20,20);
						this.pos.setX(this.pos.getX() - vel);
						this.pos.setY(this.pos.getY() - vel);
						Thread.sleep(100);
						break;
					case 6:
						this.grafico.setBounds(this.pos.getX(),this.pos.getY() - vel,20,20);
						this.pos.setY(this.pos.getY() - vel);
						Thread.sleep(100);
						break;
					case 7:
						this.grafico.setBounds(this.pos.getX() + vel, this.pos.getY() + vel,20,20);
						this.pos.setX(this.pos.getY() + vel);
						this.pos.setY(this.pos.getY() - vel);
						Thread.sleep(100);
						break;
				}
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}

	@Override
	public void moverA(Posicion pos, int vel) {
		// TODO Auto-generated method stub
		
	}
	
}
