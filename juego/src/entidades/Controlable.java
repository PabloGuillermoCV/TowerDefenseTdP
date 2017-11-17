package entidades;

import Logica.Celda;
import Logica.Posicion;
import entidades.EntidadesGraficas.EntidadGrafica;

public abstract class Controlable extends Personaje {
	
	protected int Precio;
	protected int VelocidadAt;
	protected boolean Invulnerable;
	protected Posicion Pos2;
	protected EntidadGrafica GraficoAuxiliar;
	
	public Controlable (String Nombre, Posicion Pos,
			int Vida, int Alcance, int Ataque, int Defensa, int Precio, int VelocidadAt) {
		super (Nombre,Pos,Vida,Alcance,Ataque,Defensa);
		this.Precio = Precio;
		this.VelocidadAt = VelocidadAt;
		this.miMapa.agregarControlable(this, Pos);
		this.Pos2 = null;
		this.GraficoAuxiliar = null;
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
		int res =  (miEstadoActual.getAtaque() - ((25 * e.getEstado().getDefensa())/100));
		
		if (res < 0) {
			res = 0;
		}
		return res;
	}
	
	public int getVelAt () {
		return VelocidadAt;
	}
	
	public boolean getInvulnerable () {
		return Invulnerable;
	}
	
	public void setInvulnerable (boolean Invulnerable) {
		this.Invulnerable = Invulnerable;
	}
	
	public void aumentarAlcance () {
		this.Alcance += 2;
	}
	
	public Posicion getPos2 () {
		return Pos2;
	}
	
	public EntidadGrafica getGraficoAux () {
		return GraficoAuxiliar;
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
	public void atacar (Enemigo E) {
		Posicion destino = new Posicion (E.getPos().getX(), E.getPos().getY());
		hiloGolpes.agregarALista(destino);
		E.getEstado ().setVida (E.getEstado ().getVida () - calcularGolpe (E));
		if (E != null) {
			this.serAtacado (E);
		}
	}
	
	public Enemigo verificarUnidad () {
		Enemigo ret = null;
		for (int X = Alcance; X > -Alcance && ret == null; X--) {
			for (int Y = Alcance; Y > -Alcance && ret == null; Y--) {
				if (miMapa.posicionValidaEnMapa (pos.getX () + (X * 20), pos.getY () + (Y * 20))) {
					Celda C = miMapa.getCelda (this.pos.getX()+(X*20), this.pos.getY()+(Y*20));
					if (C != null) {
						if (!C.getEnemigos ().isEmpty ()) {
							if (!C.getEnemigos().getFirst().estoyMuerto()) {
						    	ret = C.getEnemigos ().getFirst ();
						    }
						}
					}
				}
			}
		}
		return ret;
	}

	public void morir () {
		this.estoyMuerto = true;
		if (this.Pos2 != null) {
			this.miMapa.getCelda (this.Pos2.getX (), this.Pos2.getY ()).EliminarControlableDeCelda (this);
			this.Pos2 = null;
		}
		if (this.GraficoAuxiliar != null) {
			this.GraficoAuxiliar.Morir ();
			this.GraficoAuxiliar = null;
		}
		this.miMapa.eliminarControlable (this);
		this.grafico.Morir ();
		this.miMapa = null;
		this.miEstadoActual = null;
		this.pos = null;
		this.grafico = null;
	}
}