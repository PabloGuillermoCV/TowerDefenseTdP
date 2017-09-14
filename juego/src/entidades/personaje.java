package entidades;

<<<<<<< HEAD
import Mapa.powerUpDelMapa;

public abstract class personaje extends fisico {
=======
import javax.swing.JLabel;
import Mapa.Posicion;
>>>>>>> e8b91c34bc6416b919ae85cd6a0df95cdd345ad1

public abstract class personaje extends fisico {

	protected int Vida;
	protected int Alcance;
	protected PowerUpDelMapa PowerUp;
	protected int Ataque;
	protected int Defensa;
	
<<<<<<< HEAD
	public abstract void serAtacado(Controlable a);
	
	public abstract void serAtacado(enemigo e);
	
	public int getVida(){
		return vida;
	}
	public void atacar(personaje p){
		p.serAtacado(this);
	}
	public void setVida(int v){
		vida = v;
	}
	public int getAtaque(){
		return ataque;
	}
	
	public int getDefensa(){
		return defensa;
=======
	public personaje (String Nombre, JLabel Label, Posicion Pos,int Vida, int Alcance,
			PowerUpDelMapa PowerUp, int Ataque, int Defensa) {
		super (Nombre,Label,Pos);
		this.Vida = Vida;
		this.Alcance = Alcance;
		this.PowerUp = PowerUp;
		this.Ataque = Ataque;
		this.Defensa = Defensa;
	}
	
	public int getVida () {
		return Vida;
	}
	
	public int getAlcance () {
		return Alcance;
	}
	
	public PowerUpDelMapa getPoder () {
		return PowerUp;
	}
	
	public int getAtaque () {
		return Ataque;
	}
	
	public int getDefensa () {
		return Defensa;
	}
	
	public void setVida (int V) {
		Vida = V;
	}
	
	public void serAtacado (personaje P) {
		
>>>>>>> e8b91c34bc6416b919ae85cd6a0df95cdd345ad1
	}
	
	public void Atacar (personaje P) {
		P.serAtacado (this);
	}
}