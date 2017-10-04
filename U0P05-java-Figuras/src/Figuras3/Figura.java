package Figuras3;

public abstract class Figura{
	
	private String titulo;
	private Color color;
	
	public abstract double calcularPerimetro();
	public abstract double calcularArea();
	
	@Override
	public String toString() {
		return "Figura [titulo=" + titulo + ", color=" + color + "]";
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	
	
}
