package Figuras1;

public class Circunferencia {
	private double radio;

	public Circunferencia(double radio) {
		this.radio = radio;
	}

	public double getRadio() {
		return radio;
	}

	@Override
	public String toString() {
		return "Circunferencia [radio=" + radio + "]";
	}
	
	public double calcularPerimetro() {
		return 2*Math.PI*radio;
	}

	public double calcularArea() {
		return Math.PI*Math.pow(radio, 2);
	}
	
}
