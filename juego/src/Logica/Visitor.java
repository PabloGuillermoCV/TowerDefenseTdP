package Logica;

import Objetos.*;
import entidades.Controlable;
import entidades.Enemigo;
import Controlables.*;
import Enemigos.*;

public interface Visitor {

		public void visit (APie P, Controlable C);
		public void visit (ACaballo A, Controlable C);
		public void visit (ConArco CA, Controlable C);
		public void visit (ConArmadura CA, Controlable C);
		public void visit (ConBallesta CB, Controlable C);
		public void visit (JefeFinal JF, Controlable C);
		public void visit (Arquero A, Enemigo C);
		public void visit (Caballero A, Enemigo C);
		public void visit (Catapulta A, Enemigo C);
		public void visit (Elite A, Enemigo C);
		public void visit (Soldado A, Enemigo C);
		public void visit (Roca roca, Enemigo e);
}