package Figuras3;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GestorFiguras gestor=new GestorFiguras();
		Circunferencia cir1, cir2;
		Cuadrado cua1;
		Triangulo tri1;
		
		cir1=new Circunferencia(4.8,"Círculo 1", Color.Azul);
		cir2=new Circunferencia(1.5,"Círculo 2", Color.Amarillo);
		cua1=new Cuadrado(4.2,"Cuadrado 1", Color.Naranja);
		tri1=new Triangulo(8, 15,"Triángulo 1", Color.Rojo);
		
		gestor.añadirFigura(cir1);
		gestor.añadirFigura(cir2);
		gestor.añadirFigura(cua1);
		//gestor.añadirFigura(tri1);
		
		gestor.eliminarFigura(tri1);
		gestor.eliminarFigura(cir2);
		
		gestor.mostrarFiguras();
		
		System.out.println("La suma de todas las areas es: "+gestor.calcularSumatorioAreas());
	}
}
