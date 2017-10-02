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
		double pi=Math.PI;
		
		aCir1=pi*Math.pow(cir1.getRadio(), 2);
		aCir2=pi*Math.pow(cir2.getRadio(), 2);
		aCua1=Math.pow(cua1.getLado(), 2);
		aTri1=tri1.getBase()*tri1.getAltura()/2;
		
		aTotal=aCir1+aCir2+aCua1+aTri1;
		
		System.out.println("El area de la figura es: "+aTotal+".");
	}

	public static void calcularPerimetro(Circunferencia cir1, Circunferencia cir2, Cuadrado cua1, Triangulo tri1) {
		double pTotal, pCir1, pCir2, pCua1, pTri1;
		double pi=Math.PI;
		
		pCir1=pi*cir1.getRadio();
		pCir2=1.5*pi*cir2.getRadio();
		pCua1=cua1.getLado()*3;
		pTri1=tri1.getBase()+tri1.getAltura()+Math.sqrt(Math.pow(tri1.getBase(), 2)+Math.pow(tri1.getAltura(), 2))-2*(cir1.getRadio()+cir2.getRadio())-cua1.getLado();
	
		pTotal=pCir1+pCir2+pCua1+pTri1;
		
		System.out.println("El perimetro de la figura es: "+pTotal+".");
	}
	
}
