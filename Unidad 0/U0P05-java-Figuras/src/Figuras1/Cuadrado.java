package Figuras1;

public class Cuadrado {
	private double lado;
	
	public Cuadrado (double lado) {
		this.lado=lado;
	}

	public double getLado() {
		return lado;
	}

	@Override
	public String toString() {
		return "Cuadrado [lado=" + lado + "]";
	}
	
	public double calcularPerimetro() {
		return lado*4;
	}

	public double calcularArea() {
		return Math.pow(lado, 2);
	}
}
