package Enemigos;

public interface Mejorable {
	
	/**
	 * el metodo mejorar deberia ser redeefinido por cada Enemigo especifica modificando sus 
	 * atributos para tener un poco mas de vida, alcanze , fuerza . 
	 * como asumimos que lo unico que hacemos es llamar a un Random y que ese modifique, 
	 * 	la clase abstracta Enemigo podria implementarlo y que se modifique ahí
	 */
	public void mejorar();
}
