package Enemigos;

import Logica.Posicion;
import entidades.enemigo;

public class ACaballo extends enemigo {

	public ACaballo(Posicion pos){
		super ("ACaballo","SpriteBlanco2.gif",pos,50,1,null,50,100,10,false);
		this.grafico.setBounds(getPos ().getX (), getPos ().getY (), 20, 20);
	}
}
