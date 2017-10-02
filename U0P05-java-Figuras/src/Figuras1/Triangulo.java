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
	
}
