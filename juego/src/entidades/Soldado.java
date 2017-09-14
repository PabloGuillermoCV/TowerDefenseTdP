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
}