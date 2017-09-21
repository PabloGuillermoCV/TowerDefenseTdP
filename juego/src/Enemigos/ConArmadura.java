package Enemigos;

import Logica.Posicion;
import entidades.enemigo;

public class ConArmadura extends enemigo {

	public ConArmadura(Posicion pos){
		super ("ConArmadura","SpriteBlanco2.gif",pos,150,1,null,50,100,10,false);
		this.grafico.setBounds(getPos ().getX (), getPos ().getY (), 20, 20);
	}
}
