package Logica;

//import java.util.*;
//import Mapa.*;

public class MapaLogico {
	
	private Celda[][] matriz;
	private static int tamaño=20;
	
	public MapaLogico (int w, int h) {
		matriz= new Celda[w/tamaño][h/tamaño];
		for(int i=0; i<matriz.length;i++)
			for(int j=0;j<matriz[0].length;j++)
				matriz[i][j]= new Celda(i,j,this);
	}
	
	public Celda getCelda(int x,int y) {
		return matriz [x/20] [y/20];
	}
	
	public int getTamaño () {
		return tamaño;
	}
}