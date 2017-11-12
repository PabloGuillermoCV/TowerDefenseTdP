package Objetos.ObjsDeLaTienda;

import Logica.Celda;
import entidades.Controlable;
import entidades.Enemigo;

public class Explosivo extends ObjDeLaTienda {
	
	protected int Daño = 50;
	protected int Rango;
	
	public Explosivo () {
		super ("Explosivo", null, 200, 75);
		Rango = 4;
	}
	
	public void Afectar (Controlable C) {}
	
	public void Afectar (Enemigo E) {}
	
	public void Afectar () {
		Controlable C = null;
		Enemigo E = null;
		for (int X = Rango; X > -Rango && C == null; X--) {
			for (int Y = Rango; Y > -Rango && C == null; Y--) {
				if (miMapa.posicionValida (pos.getX () + (X * 20), pos.getY () + (Y * 20))) {
					Celda Cel = miMapa.getCelda (this.pos.getX()+(X*20), this.pos.getY()+(Y*20));
					if (Cel != null) {
						if (Cel.getPersonaje () != null) {
						    C = Cel.getPersonaje ();
						    C.getEstado ().setVida (C.getEstado ().getVida () - Daño);
						    if (C.getEstado().getVida() <= 0) {
								C.morir ();
							}
						}
					}
				}
			}
		}
		for (int X = Rango; X > -Rango && E == null; X--) {
			for (int Y = Rango; Y > -Rango && E == null; Y--) {
				if (miMapa.posicionValida (pos.getX () + (X * 20), pos.getY () + (Y * 20))) {
					Celda Cel = miMapa.getCelda (this.pos.getX()+(X*20), this.pos.getY()+(Y*20));
					if (Cel != null) {
						if (!Cel.getEnemigos ().isEmpty ()) {
							if (!Cel.getEnemigos ().getFirst ().estoyMuerto ()) {
						    	E = Cel.getEnemigos ().getFirst ();
						    	E.getEstado ().setVida (E.getEstado ().getVida () - Daño);
						    	if (E.getEstado().getVida() <= 0) {
									E.getMapa ().getNivel ().murioEnemigo (E);
								}
						    }
						}
					}
				}
			}
		}
	}
}