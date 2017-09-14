package entidades;

public class Soldado extends Controlable {
	
	/*
	Nombre = "Soldado"
	JLabel = null
	Posicion = null
	Vida = 50
	Alcance = 1
	PowerUpDelMapa = null
	Ataque = 50
	Defensa = 100
	Precio = 200
	Espacio [] = new int [2]
	VelocidadAt = 4
	*/
	
	public Soldado () {
		super ("Soldado",null,null,50,1,null,50,100,200,new int [2],4);
	}

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
	public void efecto() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mover() {
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
}