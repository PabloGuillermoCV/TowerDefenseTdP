package Enemigos.Movimiento;

public interface EstrategiaDeMovimiento {
	
	/**
	 * el metodo moverA , deberia implementarse de la misma manera que implementamos el metodo
	 * moverA del Soldado que implementamos para el segundo Sprint. La idea de tenerlo como 
	 * interfaz y que cada uno lo reedefina hace que cada uno se pueda mover de manera diferente.
	 * @param pos recibe la Posicion de destino
	 * Este seria el único Método, usando el Patrón State, tendriamos dos clases concretas (minimo) que serian, CaminadoNormal y CaminadoRalentizado
	 * donde la ejecución de c/u depende del estado en que se encuentre la unidad que se está moviemndo
	 * 
	 */
	public void mover();
	
	//NOTA: el metodo "moverRalentizado(Posicion pos)" ya esta implementado 
	//en la clase "CaminarMermado"
}