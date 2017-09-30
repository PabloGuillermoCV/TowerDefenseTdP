package entidades;

import Logica.Posicion;

public abstract class Enemigo extends Personaje {
	
	protected int VelocidadMov;
	protected boolean EfectoEspecial;
	protected int Puntaje;
	
	public Enemigo (String Nombre, String Label, Posicion Pos, int Vida, int Alcance,
		   PowerUpDelMapa PowerUp, int Ataque, int Defensa, int VelocidadMov, boolean EfectoEspecial,
		   int Puntaje) {
		super (Nombre,Label,Pos,Vida,Alcance,PowerUp,Ataque,Defensa);
		this.VelocidadMov = VelocidadMov;
		this.EfectoEspecial = EfectoEspecial;
		this.Puntaje = Puntaje;
	}
	
	public int getVelMov () {
		return VelocidadMov;
	}
	
	public boolean getEfecto () {
		return EfectoEspecial;
	}
	
	public int getPuntaje () {
		return Puntaje;
	}
	
	public void serAtacado (Enemigo e) {
		
	}
	
	public void serAtacado(Controlable a){
		this.setVida(this.Vida -  (this.Defensa - a.getAtaque()) );
	}
	
	public void MoverA (Posicion pos) {
		try {
			if(this.pos.getX()!= pos.getX()) {
				while(this.pos.getX()!=pos.getX()) {
					this.grafico.setBounds(this.pos.getX()+VelocidadMov, this.pos.getY(),20, 20);
					this.pos.setX(this.pos.getX()+VelocidadMov);
				    Thread.sleep(100);
				}
			}
			else {
				while(this.pos.getY()!=pos.getY()) {
					this.grafico.setBounds(this.pos.getX(), this.pos.getY()+VelocidadMov,20, 20);
					this.pos.setY(this.pos.getY()+VelocidadMov);
				    Thread.sleep(100);
				}
			}		
			this.pos=pos;
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}