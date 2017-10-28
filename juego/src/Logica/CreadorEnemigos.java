package Logica;

import Enemigos.*;

public abstract class CreadorEnemigos {

	protected abstract APie createEnemigoAPie ();
	protected abstract ACaballo createEnemigoACaballo ();
	protected abstract ConArmadura createEnemigoConArmadura ();
	protected abstract ConArco createEnemigoConArco ();
	protected abstract ConBallesta createEnemigoConBallesta ();
	protected abstract JefeFinal createEnemigoJefeFinal ();
}