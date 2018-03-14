package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Autor;
import modelo.Obra;

/**
 * Servlet implementation class MostrarCatalogoServlet
 */
@WebServlet("/MostrarCatalogo")
public class MostrarCatalogoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarCatalogoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	ServletContext contexto = getServletContext();
    	response.setContentType("text/html;UTF-8");
    	PrintWriter out = response.getWriter();
    	out.println("<html><head><meta charset='UTF-8'/></head><body>");

    	Connection conn = null;
    	Statement sentencia = null;

    	try {
    		// Paso 1: Cargar el driver JDBC.
    		Class.forName("org.mariadb.jdbc.Driver").newInstance();

    		// Paso 2: Conectarse a la Base de Datos utilizando la clase Connection
    		String userName = contexto.getInitParameter("usr_db_r");
    		String password = contexto.getInitParameter("psw_db_r");
  		  	String url=contexto.getInitParameter("srv_db")+"/catalogo10";
    		conn = DriverManager.getConnection(url, userName, password);

    		// Paso 3: Crear la sentencia SQL
    		sentencia = conn.createStatement();


    		// Paso 4: Ejecutar la sentencia SQL a través de los objetos Statement
    		String orden="";
    		if(request.getParameter("num")!=null) {
    			if(request.getParameter("num").equalsIgnoreCase("1")) {
    				orden="ORDER BY obra.nombre;";
    			}else if(request.getParameter("num").equalsIgnoreCase("2")){
    				orden="ORDER BY obra.nombre DESC;";
    			}else if(request.getParameter("num").equalsIgnoreCase("3")){
    				orden="ORDER BY autor.idAutor;";
    			}else if(request.getParameter("num").equalsIgnoreCase("4")){
    				orden="ORDER BY autor.idAutor DESC;";
    			}
    		}

    		String consulta = "SELECT idObra, obra.idAutor AS idAutor, obra.nombre AS nombre, obra.imagen AS imagenObra, autor.nombre AS nomAutor, autor.imagen AS imagenAutor from obra,autor WHERE obra.idAutor=autor.idAutor "+orden;
    		ResultSet rset = sentencia.executeQuery(consulta);

    		// Paso 5: Mostrar resultados
    		if (!rset.isBeforeFirst() ) {    
    			out.println("<p>No hay resultados</p>");
    		}


    		if(request.getParameter("nombre")!=null) {
    			String nombre=request.getParameter("nombre");
    			String consulta2 = "SELECT idObra, obra.idAutor AS idAutor, obra.nombre AS nombre, obra.imagen AS imagenObra, autor.nombre AS nomAutor, autor.imagen AS imagenAutor from obra,autor WHERE obra.idAutor=autor.idAutor AND obra.nombre LIKE '%"+nombre+"%'";
    			ResultSet rset2 = sentencia.executeQuery(consulta2);

    			if (!rset2.isBeforeFirst() ) {    
    				out.println("<p>No hay resultados</p>");
    			} else {

    				out.println("<table style='border:'5px''>");
    				out.println("<tr style='background-color:green'><td>Obra</td><td>Autor</td><td>ImagenObra</td></tr>");
    				while (rset2.next()) {
    					Obra obra2=new Obra(rset2.getString("nombre"), rset2.getString("imagenObra"),   Integer.parseInt(rset2.getString("idObra")));
    					Autor autor2=new Autor(rset2.getString("nomAutor"),rset2.getString("imagenAutor"), Integer.parseInt(rset2.getString("idAutor")));
    					out.println("<tr style='background-color:orange'>");
    					out.println("<td>" + obra2.getNombre() + "</td><td> " + autor2.getNomAutor() + "</td><td>"+obra2.getImagenObra()+"</td></tr>");
    				}
    				out.println("</table>");
    			}

    		}else  if(request.getParameter("idAutor")==null) {

    			out.println("<table style='border:'5px''>");
    			out.println("<tr style='background-color:green'><td>Obra<a href=MostrarCatalogo?num=1>&#9650;</a><a href=MostrarCatalogo?num=2>&#9660;</a></td>"
    					+ "<td>Autor<a href=MostrarCatalogo?num=3>&#9650;</a><a href=MostrarCatalogo?num=4>&#9660;</a></td>"
    					+ "<td>ImagenObra</td></tr>");
    			while (rset.next()) {
    				Obra obra=new Obra(rset.getString("nombre"), rset.getString("imagenObra"),   Integer.parseInt(rset.getString("idObra")));
    				Autor autor=new Autor(rset.getString("nomAutor"),rset.getString("imagenAutor"), Integer.parseInt(rset.getString("idAutor")));
     				out.println("<tr style='background-color:orange'>");
    				out.println("<td>" +"<a href=MostrarObra?idObra='"+obra.getIdObra()+"'>"+obra.getNombre() + "</td><td><a href=MostrarCatalogo?idAutor='"+autor.getIdAutor()+"'>"+autor.getNomAutor()+"</td><td>"+obra.getImagenObra()+"</td></tr>");
    			}
    			out.println("</table>");

    		}else if(request.getParameter("idAutor")!=null){
    			String idAutor=request.getParameter("idAutor");
    			String consulta1 = "SELECT idObra, obra.idAutor  AS idAutor, obra.nombre AS nombre, obra.imagen AS imagenObra, autor.nombre AS nomAutor, autor.imagen AS imagenAutor from obra,autor WHERE obra.idAutor="+idAutor+" AND obra.idAutor=autor.idAutor";
    			ResultSet rset1 = sentencia.executeQuery(consulta1);

    			if (!rset1.isBeforeFirst() ) {    
    				out.println("<p>No hay resultados</p>");
    			}

    			out.println("<table style='border:'5px''>");
    			out.println("<tr style='background-color:green'><td>Obra<a href=MostrarCatalogo?num=1>&#9650;</a><a href=MostrarCatalogo?num=2>&#9660;</a></td>"
    					+ "<td>Autor<a href=MostrarCatalogo?num=3>&#9650;</a><a href=MostrarCatalogo?num=4>&#9660;</a></td>"
    					+ "<td>ImagenObra</td><td>ImagenAutor</td></tr>");
    			while (rset1.next()) {
    				Obra obra1=new Obra(rset1.getString("nombre"), rset1.getString("imagenObra"),   Integer.parseInt(rset1.getString("idObra")));
    				Autor autor1=new Autor(rset1.getString("nomAutor"),rset1.getString("imagenAutor"), Integer.parseInt(rset1.getString("idAutor")));
    				out.println("<td>" +"<a href=MostrarObra?idObra='"+obra1.getIdObra()+"'>"+obra1.getNombre() + "</a></td><td> " + autor1.getNomAutor() + "</td><td>"+obra1.getImagenObra()+"</td><td>"+autor1.getImagenAutor()+"</td></tr>");
    			}
    			out.println("</table>");

    		} 



    		out.println("<form action='MostrarCatalogo' method='post'><br/>");
    		out.println("<label>Buscar obra por nombre: </label>");
    		out.println("<input type='text' name='nombre'>");
    		out.println("<input type='submit' value='Enviar' name='enviar'>");
    		out.println("</form>");



    		// Paso 6: Desconexión
    		if (sentencia != null)
    			sentencia.close();
    		if (conn != null)
    			conn.close();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}

    	out.print("<p><a href=MostrarCatalogo>Eliminar filtros</a></p>");
    	out.print("<p><a href=Cuenta>Mi cuenta</a></p>");
    	out.println("</body></html>");

    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
