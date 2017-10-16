package Enemigos;
import entidades.*;
import Logica.Posicion;

public class CaminarMermado implements EstadoDeMovimiento {

	private Enemigo e;
	
	public CaminarMermado(Enemigo e) {
		this.e = e;
	}
	
	/**
	 * metodo que, asumiendo que el personaje esta en el rio, 
	 * hace que se mueva a la mitad de la velocidad
	 * @param pos posicion a la que se moverá el enemigo
	 */
	public void moverA(Posicion pos) {
		try {
			if(e.getPos().getX()!= pos.getX()) {
				while(e.getPos().getX()!=pos.getX()) {
					e.getGrafico().setBounds(e.getPos().getX()+e.getVelMov(), e.getPos().getY(),20, 20);
					e.getPos().setX(e.getPos().getX()+(e.getVelMov()/2));
				    Thread.sleep(100);
				}
			}
			else {
				while(e.getPos().getY()!=pos.getY()) {
					e.getGrafico().setBounds(e.getPos().getX(), e.getPos().getY()+e.getVelMov(),20, 20);
					e.getPos().setY(e.getPos().getY()+(e.getVelMov()/2));
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
