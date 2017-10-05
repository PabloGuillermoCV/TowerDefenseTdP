package Logica;

public class MapaLogico {
	
	private Celda [][] matriz;
	private static int tama�o = 20;
	//private TiendaLogica market;
	
	/**
	 * constructor : inicializa la matriz de Celdas con un total de (el Ancho del Mapa)/20 por
	 * (alto del Mapa)/20. Usamos 20*20 por el tama�o del Sprite. Luego de inicializar la Matriz
	 * creamos cada Celda perteneciente a la matriz y le enviamos la posicion de su esquina izq.
	 */
	
	public MapaLogico (int w, int h) {
		matriz = new Celda [w/tama�o][h/tama�o];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz [0].length; j++) {
				matriz [i][j] = new Celda (i*tama�o,j*tama�o,this);
				
			}
		}
		//TiendaLogica market = new TiendaLogica();
	}
	
	public Celda getCelda (int x,int y) {
		return matriz [x/tama�o] [y/tama�o];
	}
	
	public int getTama�o () {
		return tama�o;
	}
	/*
	public void agregarPersonaje(int x,int y) {
		market.getControlable();
		//if(Market.getCreador() != null)
			//modificar no recibe la celda --> Market.getCreador();
		
	}
*/
}