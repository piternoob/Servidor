package Figuras1;

public class Triangulo {
	private double base, altura;
	
	public Triangulo(double base, double altura) {
		this.base=base;
		this.altura=altura;
	}

	public double getBase() {
		return base;
	}

	public double getAltura() {
		return altura;
	}

	@Override
	public String toString() {
		return "Triangulo [base=" + base + ", altura=" + altura + "]";
	}
	
	public double calcularPerimetro() {
		return base+altura+Math.sqrt(Math.pow(base, 2)+Math.pow(altura, 2));
	}

	public double calcularArea() {
		return base*altura/2;
	}
	
}
