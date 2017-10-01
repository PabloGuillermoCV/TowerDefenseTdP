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

public class VisitorConcreto implements Visitor {

	private int golpe;
	
	public VisitorConcreto(){
		golpe = 0;
	}
	@Override
	public void visit(APie P, Controlable C) {
		golpe = P.getVida() - (P.getDefensa() - C.getAtaque());
		P.setVida(P.getVida() - golpe);

	}

	@Override
	public void visit(ACaballo A, Controlable C) {
		golpe = A.getVida() - (A.getDefensa() - C.getAtaque());
		A.setVida(A.getVida() - golpe);
	}

	@Override
	public void visit(ConArco CA, Controlable C) {
		golpe = CA.getVida() - (CA.getDefensa() - C.getAtaque());
		CA.setVida(CA.getVida() - golpe);

	}

	@Override
	public void visit(ConArmadura CA, Controlable C) {
		golpe = CA.getVida() - (CA.getDefensa() - C.getAtaque());
		CA.setVida(CA.getVida() - golpe);
	}

	@Override
	public void visit(ConBallesta CB, Controlable C) {
		golpe = CB.getVida() - (CB.getDefensa() - C.getAtaque());
		CB.setVida(CB.getVida() - golpe);
	}

	@Override
	public void visit(JefeFinal JF, Controlable C) {
		golpe = JF.getVida() - (JF.getDefensa() - C.getAtaque());
		JF.setVida(JF.getVida() - golpe);
	}

	@Override
	public void visit(Arquero A, Enemigo C) {
		golpe = A.getVida() - (A.getDefensa() - C.getAtaque());
		A.setVida(A.getVida() - golpe);

	}

	@Override
	public void visit(Caballero A, Enemigo C) {
		golpe = A.getVida() - (A.getDefensa() - C.getAtaque());
		A.setVida(A.getVida() - golpe);

	}

	@Override
	public void visit(Catapulta A, Enemigo C) {
		golpe = A.getVida() - (A.getDefensa() - C.getAtaque());
		A.setVida(A.getVida() - golpe);

	}

	@Override
	public void visit(Elite A, Enemigo C) {
		golpe = A.getVida() - (A.getDefensa() - C.getAtaque());
		A.setVida(A.getVida() - golpe);
	}

	@Override
	public void visit(Soldado A, Enemigo C) {
		golpe = A.getVida() - (A.getDefensa() - C.getAtaque());
		A.setVida(A.getVida() - golpe);

	}

	@Override
	public void visit(Roca roca, Enemigo e) {
		golpe = roca.getVida() - e.getAtaque();
		roca.setVida(roca.getVida() - golpe);

	}

}
