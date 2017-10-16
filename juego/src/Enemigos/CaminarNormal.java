package Enemigos;

import Logica.Posicion;
import entidades.Enemigo;

public class CaminarNormal implements EstadoDeMovimiento {

	private Enemigo e;
	
	public CaminarNormal(Enemigo e) {
		this.e = e;
	}
	
	
	public void moverA(Posicion pos) {
		try {
			if(e.getPos().getX()!= pos.getX()) {
				while(e.getPos().getX()!=pos.getX()) {
					e.getGrafico().setBounds(e.getPos().getX()+e.getVelMov(), e.getPos().getY(),20, 20);
					e.getPos().setX(e.getPos().getX()+e.getVelMov());
				    Thread.sleep(100);
				}
			}
			else {
				while(e.getPos().getY()!=pos.getY()) {
					e.getGrafico().setBounds(e.getPos().getX(), e.getPos().getY()+e.getVelMov(),20, 20);
					e.getPos().setY(e.getPos().getY()+e.getVelMov());
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
