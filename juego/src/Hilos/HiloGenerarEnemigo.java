package Hilos;

import java.util.Iterator;
import Logica.Niveles.Nivel;

public class HiloGenerarEnemigo extends Thread {
	
	protected Nivel miNivel;
	protected volatile boolean Bloqueo = true;
	protected boolean Iniciar = false;
	
	public HiloGenerarEnemigo (Nivel miNivel) {
		this.miNivel = miNivel;
	}
	
	public void run () {
		int ContTotal = 0;
		Iterator <Integer> Oleada = miNivel.getEnemigosPorOleada ().iterator ();
		int ContOleada = (Integer) Oleada.next ();
		while (ContTotal < this.miNivel.getCantidadEnemigos ()) {
			while (Bloqueo == false) {
				if (ContTotal == ContOleada) {
					Bloqueo = true;
					if (!Oleada.hasNext ()) {
						break;
					}
					miNivel.getTienda ().habilitarOleada ();
					ContOleada = (Integer) Oleada.next ();
				}
				else {
					miNivel.mandarEnemigo ();
					ContTotal++;
					try {
						Thread.sleep (3000);
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public void Desbloquear () {
		//Desbloquea para poder mandar la siguiente oleada
		Bloqueo = false;
	}
	
	public boolean yaEmpezoElNivel () {
		//Consulta si el metodo run ya se esta ejecutando
		return Iniciar;
	}
	
	public void IniciarNivel () {
		//Este metodo solo se llama si aun no empezo la primera oleada del nivel
		Iniciar = true;
	}
}