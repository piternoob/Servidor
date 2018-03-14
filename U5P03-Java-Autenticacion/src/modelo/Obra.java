package modelo;

public class Obra {
	
	private String nombre, imagenObra;
	private int idObra;
    
	public Obra(String nombre, String imagenObra, int idObra) {
		this.nombre=nombre;
		this.imagenObra=imagenObra;
		this.idObra=idObra;
	}
	
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	
	public String getImagenObra() { return "<img src='/U5P02-Java-Catalogo/img/"+imagenObra+"'height=200px width=200px>";}
	public void setImagenObra(String imagenObra) {this.imagenObra = imagenObra;}
	
	public int getIdObra() {return idObra;}
	public void setIdObra(int idObra) {this.idObra = idObra;}

}