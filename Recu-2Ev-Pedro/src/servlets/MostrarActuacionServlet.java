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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MostrarActuacionServlet
 */
@WebServlet("/MostrarActuacion")
public class MostrarActuacionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarActuacionServlet() {
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
    	out.println("<h1>Primavera Sound</h1>");
    	out.println("<img src='./img/portada.jpg'>");
    	Connection conn = null;
    	Statement sentencia = null;

    	try {
    		Class.forName("org.mariadb.jdbc.Driver").newInstance();

    		String userName = "alumno";
    		String password = "alumno";
    		String url = "jdbc:mariadb://localhost/ps2013";
    		conn = DriverManager.getConnection(url, userName, password);

    		sentencia = conn.createStatement();

    		if(request.getParameter("idActuacion")!=null) {
    			String consulta = "SELECT nombre, origen, descripcion, imagen ,url, dia FROM actuacion WHERE id="+request.getParameter("idActuacion");
    			ResultSet rset = sentencia.executeQuery(consulta);
    			
    			
    			if (!rset.isBeforeFirst() ) {    
    				out.println("<h3>No hay resultados</h3>");
    			}

    			out.println("<ol>");
    			while (rset.next()) {
    				out.println("<li>Nombre: "+rset.getString("nombre")+"</li>");
    				out.println("<li>Origen: "+rset.getString("origen")+"</li>");
    				out.println("<li>Descripcion: "+rset.getString("descripcion")+"</li>");
    				out.println("<li><img src=./img/artistas/"+rset.getString("imagen")+"></li>");
    				out.println("<li>URL: "+rset.getString("url")+"</li>");
    				out.println("<li>Dia: "+rset.getString("dia")+"</li>");
    				}
    			out.println("</table>");
    			
    		} else
    			out.println("<h3>No hay resultados</p>");
    		
    		if (sentencia != null)
    			sentencia.close();
    		if (conn != null)
    			conn.close();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	;
    	out.println("<a href=Principal>Principal</a></br>");
    	out.println("<a href=MostrarCartel>MostrarCartel</a>");
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
