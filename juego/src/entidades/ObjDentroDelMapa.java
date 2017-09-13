package entidades;

import java.awt.Graphics;

import javax.swing.JLabel;

import Mapa.Posicion;

public abstract class ObjDentroDelMapa extends fisico {
	
	protected int Probabilidad;
	
	public ObjDentroDelMapa (String nombre, Graphics label, JLabel getLabel, Posicion Pos, int Width,
			int Height, int Probabilidad) {
		super (nombre,label,getLabel,Pos,Width,Height);
		this.Probabilidad = Probabilidad;
	}
	
	public int getProb(){
		return Probabilidad;
	}
	
	/* No se si as operaciones que hereda de la clase "entidad" deben ser implementadas acá (y para cualquier clase que herede de entidad) 
	 * o si las implementaremos en las clases concretas
	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCod() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void atacar(entidad e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void efecto() {
		// TODO Auto-generated method stub

	}

	@Override
	public int morir() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int vender() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void mover() {
		// TODO Auto-generated method stub

	}

	@Override
	public void iniciarAtaque() {
		// TODO Auto-generated method stub

	}
	*/
}