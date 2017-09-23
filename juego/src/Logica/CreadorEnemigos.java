package Logica;

import Enemigos.*;

public abstract class CreadorEnemigos {

	protected abstract APie createEnemigoAPie();
	protected abstract ACaballo createEnemigoACaballo();
	protected abstract ConArmadura createEnemigoConArmadura();
}