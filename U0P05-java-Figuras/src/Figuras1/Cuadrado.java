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
	
}
