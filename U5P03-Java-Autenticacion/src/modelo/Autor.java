package modelo;

public class Autor {

	private String nomAutor, imagenAutor;
	private int idAutor;
	
	public Autor(String nomAutor, String imagenAutor, int idAutor) {
		this.nomAutor=nomAutor;
		this.imagenAutor=imagenAutor;
		this.idAutor=idAutor;
	}
	
	public String getNomAutor() {return nomAutor;}
	public void setNomAutor(String nomAutor) {this.nomAutor = nomAutor;}
	
	public String getImagenAutor() {return "<img src='/U5P03-Java-Autenticacion/img/"+imagenAutor+"'height=200px width=200px>";}
	public void setImagenAutor(String imagenAutor) {this.imagenAutor = imagenAutor;}
	
	public int getIdAutor() {return idAutor;}
	public void setIdAutor(int idAutor) {this.idAutor = idAutor;}
	
}
