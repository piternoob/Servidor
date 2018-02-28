package servlets;
public class Obra {
	private String nombre, imagenObra, nomAutor, imagenAutor;
	private int idObra, idAutor;
	
	public Obra(String nombre, String imagenObra, String nomAutor, String imagenAutor, int idObra, int idAutor) {
		this.nombre=nombre;
		this.imagenObra=imagenObra;
		this.nomAutor=nomAutor;
		this.imagenAutor=imagenAutor;
		this.idObra=idObra;
		this.idAutor=idAutor;
	}
	
	public String getNombre() {return nombre;}
	public String getImagenObra() { return "<img src='/U5P02-Java-Catalogo/img/"+imagenObra+"'height=200px width=200px>";}
	public String getNomAutor() {return nomAutor;}
	public String getImagenAutor() {return "<img src='/U5P02-Java-Catalogo/img/"+imagenAutor+"'height=200px width=200px>";}
	public int getIdObra() {return idObra;}
	public int getIdAutor() {return idAutor;}

}