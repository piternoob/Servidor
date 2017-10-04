package Figuras3;

import java.util.ArrayList;

public class GestorFiguras {

	/** 
	 * La clase tiene un atributo de tipo ArrayList que almacenará nuestras figuras
	 */
	private ArrayList<Figura> array;

	/** 
	 * Constructor de la clase, inicializa el ArrayList
	 */
	public GestorFiguras() {
		array=new ArrayList<Figura>();
	} 

	/** 
	 * Método añadirFigura que nos añade una figura a nuestro ArrayList
	 * @param f1 es el objeto que vamos a añadir al ArrayList
	 */
	public void añadirFigura(Figura f1) {
		System.out.println("Añadiendo figura...");
		array.add(f1);
	}

	/** 
	 * Método eliminarFigura que nos elimina una figura de nuestro ArrayList en caso de que este guardada
	 * @param f1 es el objeto que vamos a intentar eliminar del ArrayList
	 */
	public void eliminarFigura(Figura f1) {
		
		if (array.contains(f1)) {
			System.out.println("Eliminando figura...");
			array.remove(f1);
		}
		else
			System.out.println("No se ha encontrado la figura");
			
	}

	/** 
	 * Método mostrarFiguras que visualizará el método toString de cada figura de nuestro ArrayList
	 */
	public void mostrarFiguras() {
		System.out.println("Mostrando todas las figuras...");
		for(Figura f : array)
			System.out.println(f.toString());
	}
	
	/** 
	 * Método calcularSumatorioAreas que nos va sumando las areas de cada figura del ArrayList
	 */
	public void calcularSumatorioAreas() {
		double suma=0;
		for(Figura f : array)
			suma+=f.calcularArea();
		System.out.println("La suma de todas las áreas es: "+suma);
	}

}
