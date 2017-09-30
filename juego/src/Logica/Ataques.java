package Logica;

import Controlables.Arquero;
import Controlables.Caballero;
import Controlables.Catapulta;
import Controlables.Elite;
import Controlables.Soldado;
import Enemigos.ACaballo;
import Enemigos.APie;
import Enemigos.ConArco;
import Enemigos.ConArmadura;
import Enemigos.ConBallesta;
import Enemigos.JefeFinal;
import Objetos.Roca;
import entidades.Controlable;
import entidades.Enemigo;

public class Ataques implements Visitor {

	private int golpe;
	public Ataques(){
		golpe = 0;
	}
	@Override
	public void visit(APie P, Controlable C) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void visit(ACaballo A, Controlable C) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void visit(ConArco CA, Controlable C) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void visit(ConArmadura CA, Controlable C) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void visit(ConBallesta CB, Controlable C) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void visit(JefeFinal JF, Controlable C) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void visit(Arquero A, Enemigo C) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void visit(Caballero A, Enemigo C) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void visit(Catapulta A, Enemigo C) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void visit(Elite A, Enemigo C) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void visit(Soldado A, Enemigo C) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void visit(Roca roca, Enemigo e) {
		golpe = roca.getVida() - e.getAtaque();
		roca.setVida(roca.getVida()-golpe);
	}
	
}
