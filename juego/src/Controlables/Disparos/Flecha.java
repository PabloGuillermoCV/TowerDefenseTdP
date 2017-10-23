package Controlables.Disparos;

import entidades.Proyectil;
import Logica.Posicion;

public class Flecha extends Proyectil {

	public Flecha(){
		direccionDibujo = "Flecha.GIF";
		velocidadMovimiento = 5;
	}

	@Override
	public void volarAPosicion(Posicion p) {
		while(posActual.getX() != p.getX() && posActual.getY() != p.getY()) {
			int x1 = posActual.getX();
			int y1 = posActual.getY();
			int x2 = p.getX();
			int y2 = p.getY();
			
			if(x1 > x2) { //la Posicion del disparador es mayor que la del disparado en X
				if(y1 > y2) { //la Posicion del disparador es mayor que la del disparado en Y
					//Hacer que la flecha viaje haciendo uso de los x e y dados (usar setBounds()?)
					//acá, el disparado estaria en el segundo cuadrante de coordenadas
				}
				else { //la posicion del disparado es mayor que la del disparador en Y
					//acá, el disparado estaria en el tercer cuadrante de coordenadas
				}
			}
			else { //la Posicion del disparado es mayor que la del disparador en X
				if(y1 > y2) {
					//acá, el disparado estaria en el primer cuadrante de coordenadas
				}
				else {
					//acá, el disparado estaria en el cuarto cuadrante de coordenadas
				}
			}
		}
		
		
	}

}