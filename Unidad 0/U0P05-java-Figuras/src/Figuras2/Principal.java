package Figuras2;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circunferencia cir1, cir2;
		Cuadrado cua1;
		Triangulo tri1;
		
		cir1=new Circunferencia(4.8,"Círculo 1", Color.Azul);
		cir2=new Circunferencia(1.5,"Círculo 2", Color.Amarillo);
		cua1=new Cuadrado(4.2,"Cuadrado 1", Color.Naranja);
		tri1=new Triangulo(8, 15,"Triángulo 1", Color.Rojo);
		
		System.out.println(cir1.toString()+"\n"+
				cir2.toString()+"\n"+
				cua1.toString()+"\n"+
				tri1.toString());
	}
	
}
