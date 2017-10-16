package Enemigos;

import Logica.Posicion;
import entidades.Enemigo;

public class CaminarDa�ado implements EstadoDeMovimiento {

	private Enemigo e;
	
	public CaminarDa�ado(Enemigo e) {
		this.e = e;
	}
	/**
	 * metodo que, asuminedo que el enemigo esta en un campo da�ino,
	 * le saca 5 de vida cada vez que se mueve
	 * @param pos la posicion donde se mover� el enemigo
	 */
	public void moverA(Posicion pos) {
		try {
			if(e.getPos().getX()!= pos.getX()) {
				while(e.getPos().getX()!=pos.getX()) {
					e.getGrafico().setBounds(e.getPos().getX()+e.getVelMov(), e.getPos().getY(),20, 20);
					e.getPos().setX(e.getPos().getX()+e.getVelMov());
					e.setVida(e.getVida() - 5);
				    Thread.sleep(100);
				}
			}
			else {
				while(e.getPos().getY()!=pos.getY()) {
					e.getGrafico().setBounds(e.getPos().getX(), e.getPos().getY()+e.getVelMov(),20, 20);
					e.getPos().setY(e.getPos().getY()+e.getVelMov());
					e.setVida(e.getVida() - 5);
				    Thread.sleep(100);
				}
			}		
			e.setPos(pos);
			e.getGrafico().setVisible(false);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
