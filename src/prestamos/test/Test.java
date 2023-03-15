package prestamos.test;


import java.util.List;
import prestamos.util.Ficheros;


public class Test {

	public static void main(String[] args) {
		List<Prestamo> l = Ficheros.parse("./data/prestamos.csv", Prestamo::parse, true);
		
		/***************** Pruebe aquí los métodos estáticos del ejercicio 2 *****************************/
		

	}
	
	/*********************** Implemente aquí los métodos estáticos del ejercicio 2 ****************************/

}
