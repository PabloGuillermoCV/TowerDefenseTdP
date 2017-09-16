package entidades;

public class Soldado extends Controlable {
	
	/*
	Nombre = "Soldado"
	JLabel = GifSoldado.gif
	Posicion = null
	Vida = 50
	Alcance = 1
	PowerUpDelMapa = null
	Ataque = 50
	Defensa = 100
	Precio = 200
	DosEspacios = False
	VelocidadAt = 4
	*/
	
	public Soldado () {
		super ("Soldado","/sprites/GifSoldado.gif",null,50,1,null,50,100,200,false,4);
	}
}