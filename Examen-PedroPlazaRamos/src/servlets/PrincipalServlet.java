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
 * Servlet implementation class MostrarCartelServlet
 */
@WebServlet("/Principal")
public class PrincipalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	  public PrincipalServlet() {
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
    	
    	if(request.getParameter("idioma")!=null) {
			if(request.getParameter("idioma").equalsIgnoreCase("en")){
				Cookie idiomaCookie = new Cookie("idioma", "'en'");
				idiomaCookie.setPath("/Recu-2Ev-Pedro");
				idiomaCookie.setMaxAge(60*60*24*7);
    			response.addCookie(idiomaCookie);
    			response.sendRedirect(request.getRequestURI());
			} else if(request.getParameter("idioma").equalsIgnoreCase("es")){
				Cookie idiomaCookie = new Cookie("idioma", "'es'");
				idiomaCookie.setPath("/Recu-2Ev-Pedro");
				idiomaCookie.setMaxAge(60*60*24*7);
    			response.addCookie(idiomaCookie);
    			response.sendRedirect(request.getRequestURI());
			}
		}
    	
    	out.println("<html><head><meta charset='UTF-8'/></head><body>");
    	out.println("<h1>Primavera Sound</h1>");
    	out.println("<img src='./img/portada.jpg'>");
    	Connection conn = null;
    	Statement sentencia = null;

    	try {
    		// Paso 1: Cargar el driver JDBC.
    		Class.forName("org.mariadb.jdbc.Driver").newInstance();

    		// Paso 2: Conectarse a la Base de Datos utilizando la clase Connection
    		String userName = "alumno";
    		String password = "alumno";
    		String url = "jdbc:mariadb://localhost/ps2013";
    		conn = DriverManager.getConnection(url, userName, password);

    		// Paso 3: Crear la sentencia SQL
    		sentencia = conn.createStatement();


    		// Paso 4: Ejecutar la sentencia SQL a través de los objetos Statement  
    		String idioma="'es'";
    		Cookie cookie = buscarCookie("idioma", request);
        	if (cookie != null) 
        		idioma=cookie.getValue();
    		String consulta="SELECT presentacion FROM info WHERE idioma LIKE "+idioma;
    		ResultSet rset = sentencia.executeQuery(consulta);

    		// Paso 5: Mostrar resultados
    		if (!rset.isBeforeFirst())	
    			out.println("<p>No hay resultados</p>");
    		while (rset.next())
    			out.println("<p>"+rset.getString("presentacion")+"</p>");
    		out.println("<a href=MostrarCartel?idioma=es><img src='./img/es.png'></a>");
    		out.println("<a href=MostrarCartel?idioma=en><img src='./img/en.png'></a>");

    		out.println("<p>Cartel:</p>");
    		String consulta2="SELECT DISTINCT id, dia, mes, año FROM dias";
    		ResultSet rset2= sentencia.executeQuery(consulta2);
    		if (!rset2.isBeforeFirst())	
    			out.println("<p>No hay resultados</p>");
    		out.println("<ol>");
    		while (rset2.next())
    			out.println("<a href=MostrarCartel?dia="+rset2.getString("id")+"><li>"+rset2.getString("dia")+"/"+rset2.getString("mes")+"/"+rset2.getString("año")+"</li></a>");
    		out.println("</ol>");
    		
    		/*String dia="1";
    		if(request.getParameter("dia")!=null)
    			dia=request.getParameter("dia");
    		String orden="";
    		if(request.getParameter("num")!=null) {
    			if(request.getParameter("num").equalsIgnoreCase("1")) {
    				orden="ORDER BY nombre";
    			}else if(request.getParameter("num").equalsIgnoreCase("2")){
    				orden="ORDER BY nombre DESC";
    			}
    		}
    		
    		
    		String consulta3="SELECT nombre, origen, dia FROM actuacion WHERE dia="+dia;
    		ResultSet rset3= sentencia.executeQuery(consulta3);
    		if (!rset3.isBeforeFirst() )   
				out.println("<h3>No hay resultados</p>");
    		out.println("<h2>Mostrando el día "+dia+"</h2>");
			out.println("<table style='border:'5px''>");
			out.println("<tr style='background-color:green'>"
					+ "<td>Nombre del artista<a href=MostrarCartel?num=1>&#9650;</a><a href=MostrarCartel?num=2>&#9660;</a></td>"
					+ "<td>País de origen</td></tr>");
			while (rset3.next()) {
				out.println("<tr style='background-color:orange'>");
				out.println("<td>"+rset3.getString("nombre")+"</td><td>"+rset3.getString("origen")+"</td></tr>");
			}
			out.println("</table>");
    		*/
    		
    		
    		// Paso 6: Desconexión
    		if (sentencia != null)
    			sentencia.close();
    		if (conn != null)
    			conn.close();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	
    	
    	out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


	private Cookie buscarCookie(String nombreCookie, HttpServletRequest request) {
		Cookie ck=null;
		Cookie[] cookies=request.getCookies();
		if(cookies!=null)
			for(Cookie c: cookies)
				if(c.getName().equals(nombreCookie))
					ck=c;
		return ck;
	}
	
	
}
