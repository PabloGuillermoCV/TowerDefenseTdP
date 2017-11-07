package entidades.EntidadesGraficas;

import javax.swing.JLabel;
import GUI.MapaVisual;
import Logica.Posicion;
import entidades.Proyectil;

public class EntidadGraficaAtaque {
	protected Posicion pos;
	protected boolean bloqueado;
	protected JLabel graficoActual;
	protected Proyectil miProyectil; //agregar comportamiento, ya estaria, probar y ver q pasa
	protected MapaVisual miMapa;
	protected JLabel [] OrientacionSprite = new JLabel [8];
	
	public EntidadGraficaAtaque (String [] File, Posicion pos,Proyectil p) {
		for (int I = 0; I < 8; I++) {
			OrientacionSprite [I] = new JLabel (File [I]);
		}
		this.pos = pos;
		miMapa = MapaVisual.InstanciaMapaVisual();
		graficoActual = OrientacionSprite[0];
		miProyectil = p;
		bloqueado = true;
	}

	public void Morir() {
		OrientacionSprite = null;
	}
	
	public void moverA(Posicion pos, int vel, int orientacion) {
		if(!bloqueado) {
			graficoActual = OrientacionSprite [orientacion];
				System.out.println("Estoy volando graficamente");
					//como como me muevo depende de la orientacion del proyectil y hay 8 direcciones posibles, es mejor un switch que 8 ifs seguidos
					switch(orientacion){
						case 0:
							miMapa.getFondo().add(graficoActual);
							this.graficoActual.setBounds(this.pos.getX() + vel, this.pos.getY(), 20, 20);
							graficoActual.setVisible(true);
							this.pos.setX(this.pos.getX() + vel);
							break;
						case 1:
							miMapa.getFondo().add(graficoActual);
							this.graficoActual.setBounds(this.pos.getX() + vel, this.pos.getY() + vel,20,20);
							graficoActual.setVisible(true);
							this.pos.setX(this.pos.getX() + vel);
							this.pos.setY(this.pos.getY() + vel);
							break;
						case 2:
							miMapa.getFondo().add(graficoActual);
							this.graficoActual.setBounds(this.pos.getX(), this.pos.getY() + vel, 20,20);
							graficoActual.setVisible(true);
							this.pos.setY(this.pos.getY() + vel);
							break;
						case 3:
							miMapa.getFondo().add(graficoActual);
							this.graficoActual.setBounds(this.pos.getX() - vel, this.pos.getY() + vel, 20,20);
							graficoActual.setVisible(true);
							this.pos.setX(this.pos.getX() - vel);
							this.pos.setY(this.pos.getY() + vel);
							break;
						case 4:
							miMapa.getFondo().add(graficoActual);
							this.graficoActual.setBounds(this.pos.getX() - vel, this.pos.getY(),20,20);
							graficoActual.setVisible(true);
							this.pos.setX(this.pos.getX() - vel);
							break;
						case 5:
							miMapa.getFondo().add(graficoActual);
							this.graficoActual.setBounds(this.pos.getX()-vel, this.pos.getY()-vel,20,20);
							graficoActual.setVisible(true);
							this.pos.setX(this.pos.getX() - vel);
							this.pos.setY(this.pos.getY() - vel);
							break;
						case 6:
							miMapa.getFondo().add(graficoActual);
							this.graficoActual.setBounds(this.pos.getX(),this.pos.getY() - vel,20,20);
							graficoActual.setVisible(true);
							this.pos.setY(this.pos.getY() - vel);
							break;
						case 7:
							miMapa.getFondo().add(graficoActual);
							this.graficoActual.setBounds(this.pos.getX() + vel, this.pos.getY() + vel,20,20);
							graficoActual.setVisible(true);
							this.pos.setX(this.pos.getY() + vel);
							this.pos.setY(this.pos.getY() - vel);
							break;
					}
					bloqueado = true;
					miProyectil.desbloqueate();
			}
		}

	public void desbloqueate() {
		bloqueado = false;
	}	
}
