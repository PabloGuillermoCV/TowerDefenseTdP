package Logica;

public class Tester {
	public static void main (String args[]) {
		Camino c = new Camino1Aux ();
		c.generarCamino(/*new Posicion(480,300)*/);
		
		Posicion pos = new Posicion (0,0);
		while (c.getNext(pos)!=null) {
			System.out.println("imprimo primer pos"+c.getNext(pos));
			System.out.println("imprimo pos"+pos.toString());
			pos= c.getNext(pos);
			System.out.println("imprimo pos final"+pos);
		}
	}
}
