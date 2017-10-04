package Figuras1;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circunferencia cir1, cir2;
		Cuadrado cua1;
		Triangulo tri1;
		
		cir1=new Circunferencia(4.8);
		cir2=new Circunferencia(1.5);
		cua1=new Cuadrado(4.2);
		tri1=new Triangulo(8, 15);
		
		calcularArea(cir1, cir2, cua1, tri1);
		calcularPerimetro(cir1, cir2, cua1, tri1);
	}
	
	public static void calcularArea(Circunferencia cir1, Circunferencia cir2, Cuadrado cua1, Triangulo tri1) {
		double aTotal, aCir1, aCir2, aCua1, aTri1;
		
		aCir1=cir1.calcularArea();
		aCir2=cir2.calcularArea();
		aCua1=cua1.calcularArea();
		aTri1=tri1.calcularArea();
		
		aTotal=aCir1/2+aCir2*0.75+aCua1+aTri1;
		
		System.out.println("El area de la figura es: "+aTotal+".");
	}

	public static void calcularPerimetro(Circunferencia cir1, Circunferencia cir2, Cuadrado cua1, Triangulo tri1) {
		double pTotal, pCir1, pCir2, pCua1, pTri1;
		
		pCir1=cir1.calcularPerimetro();
		pCir2=cir2.calcularPerimetro();
		pCua1=cua1.calcularPerimetro();
		pTri1=tri1.calcularPerimetro();
	
		pTotal=pCir1/2+pCir2*0.75+pCua1*0.75+pTri1-cir1.getRadio()*2-cir2.getRadio()*2-cua1.getLado();
		
		System.out.println("El perimetro de la figura es: "+pTotal+".");
	}
	
}
