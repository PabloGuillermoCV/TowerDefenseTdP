package entidades;

import Logica.Celda;
import Logica.Posicion;
import Objetos.ObjsDeLaTienda.Explosivo;

public abstract class Controlable extends Personaje {
	protected int Precio;
	protected int VelocidadAt;
	
	
	public Controlable (String Nombre, Posicion Pos,
			int Vida, int Alcance, int Ataque, int Defensa, int Precio,int VelocidadAt) {
		super (Nombre,Pos,Vida,Alcance,Ataque,Defensa);
		
		this.Precio = Precio;
		this.VelocidadAt = VelocidadAt;
		this.miMapa.agregarControlable(this, Pos);
	}
	
	public int getPrecio () {
		return Precio;
	}
		
	/**
	 * metedo que calcula cuanto daño hará una unidad aliada contra cierto enemigo
	 * @param e enemigo que es atacado
	 * @return daño a generar en el enemigo
	 */
	public int calcularGolpe(Enemigo e){
		return e.getEstado().getVida() - (e.getEstado().getDefensa() - miEstadoActual.getAtaque());
	}
	
	public int getVelAt () {
		return VelocidadAt;
	}
	
	/**
	 * metodo que permite al controlable ser atacado por una unidad enemiga
	 * @param e visitor que efectua el ataque
	 */
	public void serAtacado(Enemigo e){
		e.atacar(this);
	}
	
	/**
	 * metodo de visitor que permite a un controlable atacar una unidad concreta
	 * @param E enemigo a atacar
	 */
	public abstract void atacar(Enemigo E);
	
	public Enemigo verificarUnidad() {
		Enemigo ret = null;
		for(int X = Alcance; X > -Alcance && ret == null; X--) {
			for(int Y = Alcance; Y > -Alcance && ret == null; Y--) {
				Celda C = miMapa.getCelda(pos.getX()+(X*20), pos.getY()+(Y*20));
				//System.out.println ("ENTRO A ---------------------------------------------------");
				if(C != null) {
					if(!C.getEnemigos().isEmpty()) {
						ret = C.getEnemigos().getFirst();
					}
				}
			}
		}
		return ret;
	}

	public void morir() {
		miMapa.eliminarControlable(this);
		this.grafico.Morir();
		this.miMapa=null;
		this.miEstadoActual=null;
		this.pos=null;
		this.grafico=null;
	}
}