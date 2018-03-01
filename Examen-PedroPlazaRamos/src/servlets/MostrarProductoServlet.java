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
import javax.servlet.http.HttpSession;

import modelo.Usuario;


/**
 * Servlet implementation class MostrarProductoServlet
 */
@WebServlet("/MostrarProducto")
public class MostrarProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarProductoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
    	ServletContext contexto = getServletContext();
    	PrintWriter out = response.getWriter();
    	Usuario usuario = (Usuario) session.getAttribute("usuario");
		
    	response.setContentType("text/html;UTF-8");
    	out.println("<h1>Sesión iniciada como <a href='"+contexto.getContextPath()+"/Cuenta'>" + usuario.getNombre() + "</a></h1>");
		
    	
    	Connection conn = null;
    	Statement sentencia = null;

    	try {
		 Class.forName("org.mariadb.jdbc.Driver").newInstance();

		  String userName = "alumno";
		  String password = "alumno";
		  String url = "jdbc:mariadb://localhost/supermercado";
		  conn = DriverManager.getConnection(url, userName, password);

		  sentencia = conn.createStatement();

		  String prod="";
			if(request.getParameter("idProd")!=null) {
				prod="&& idProd="+request.getParameter("idProd");
			}
			
		  String consulta = "SELECT * from producto, ubicacion WHERE producto.ubicacion=ubicacion.idubicacion "+prod;
		  ResultSet rset = sentencia.executeQuery(consulta);
		  if (!rset.isBeforeFirst() ) {    
			    out.println("<h3>No hay resultados</p>");
			}
		  // nombre marca precio stock descripcion imagen familia 
		  //pasillo modulo altura hueco
		 
		 
		  
		  out.println("<table style='border:'5px''>");
		  out.println("<tr style='background-color:green'><td>Nombre</td><td>Marca</td>"
		  +"<td>Precio</td><td>Stock</td><td>Descipcion</td><td>Imagen</td><td>Familia</td>"
		  +"td>Pasillo</td><td>Modulo</td><td>Altura</td><td>Hueco</td></tr>");
		  while (rset.next()) {
			 out.println("<tr style='background-color:orange'>");
			  
			  out.println("<td>" + rset.getString("nombre") + "</td><td> " + rset.getString("marca") + "</td><td>"+rset.getString("precio")+"</td>"
			  +"<td>" + rset.getString("stock") + "</td><td> " + rset.getString("descripcion") +"</td><td><img src=./img/productos/"+rset.getString("imagen")+"></td>"
			  +"<td>" + rset.getString("familia") + "</td><td> " + rset.getString("pasillo") +"</td><td>"+rset.getString("modulo")+"</td>"
			  +"<td>" + rset.getString("altura") + "</td><td> " + rset.getString("hueco") +"</td></tr>");
		  }
		  out.println("</table>");

		  if (sentencia != null)
		    sentencia.close();
		  if (conn != null)
		    conn.close();
		} catch (Exception e) {
		  e.printStackTrace();
		}
	
    	out.print("<a href=./MostrarMercado>Volver</a>");
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
