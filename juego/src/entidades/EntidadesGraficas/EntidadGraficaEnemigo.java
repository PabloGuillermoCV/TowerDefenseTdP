package entidades.EntidadesGraficas;

import Logica.Posicion;
import entidades.Enemigo;

public class EntidadGraficaEnemigo  extends EntidadGrafica {
	
	private boolean bloqueado;
	private Enemigo miEnemigo; //necesito que la parte gráfica del enemigo conozca su enemigo lógico para que lo desbloqueé al moverse
	
	public EntidadGraficaEnemigo (String File, Posicion pos,Enemigo e) {
		super (File, pos);
		this.grafico.setVisible (false);
		bloqueado = true;
		miEnemigo = e;
	}
	
	public void moverA (Posicion pos, int vel) {
		if(!bloqueado){
			try {
				//System.out.println("moverA X: "+pos.getX()+" Y: "+pos.getY());
				if (this.pos.getX() != pos.getX()) {
					if (this.pos.getX() < pos.getX()) {
						while (this.pos.getX() < pos.getX()) {
							this.grafico.setBounds (this.pos.getX () + vel, this.pos.getY (), 20, 20);
							this.pos.setX (this.pos.getX () + vel);
							Thread.sleep (100);
					}
				}
				else { //this.pos.getX > pos.getX
					while (this.pos.getX() > pos.getX()) {
						this.grafico.setBounds (this.pos.getX () - vel, this.pos.getY (), 20, 20);
					    this.pos.setX (this.pos.getX () - vel);
						Thread.sleep (100);
					}
				}
				}
				else {
					if (this.pos.getY() < pos.getY()) {
						while (this.pos.getY() < pos.getY()) {
							this.grafico.setBounds (this.pos.getX (), this.pos.getY () + vel, 20, 20);
							this.pos.setY (this.pos.getY () + vel);
							Thread.sleep (100);
						}
					}
					else { //this.pos.getY > pos.getY
						while (this.pos.getY() > pos.getY()) {
							this.grafico.setBounds (this.pos.getX (), this.pos.getY () - vel, 20, 20);
							this.pos.setY (this.pos.getY () - vel);
							Thread.sleep (100);
						}
					}
				}		
				this.pos = pos;
			}
			catch (InterruptedException e) {
				e.printStackTrace ();
			}
			bloqueado = true;
			miEnemigo.desbloqueado(); //una vez que bloqueo la gráfica, desbloqueo la lógica para que se mueva
		}
		
	}
	
	public void moverA (Posicion pos, int vel, int orientacion) {}

	@Override
	public void desbloqueate() {
		bloqueado = false;
	}
}