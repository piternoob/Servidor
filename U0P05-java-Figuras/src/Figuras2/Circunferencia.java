package Figuras2;

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
	
	
}
