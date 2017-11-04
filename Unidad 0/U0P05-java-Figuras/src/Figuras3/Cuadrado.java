package Figuras3;

public class Cuadrado extends Figura{
	private double lado;
	
	public Cuadrado (double lado, String titulo, Color color) {
		super.setColor(color);
		super.setTitulo(titulo);
		this.lado=lado;
	}

	public double getLado() {
		return lado;
	}
	
	@Override
	public double calcularPerimetro() {
		// TODO Auto-generated method stub
		return lado*4;
	}

	@Override
	public double calcularArea() {
		// TODO Auto-generated method stub
		return Math.pow(lado, lado);
	}

	@Override
	public String toString() {
		return "Cuadrado [lado=" + lado + ", calcularPerimetro()=" + calcularPerimetro() + ", calcularArea()="
				+ calcularArea() + ", toString()=" + super.toString() + "]";
	}
	
	
}
