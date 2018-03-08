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
@WebServlet("/MostrarCartel")
public class MostrarCartelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarCartelServlet() {
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

    		String dia="1";
    		if(request.getParameter("dia")!=null) {
    			dia=request.getParameter("dia");
    			Cookie diaCookie = new Cookie("dia", dia);
				diaCookie.setPath("/Recu-2Ev-Pedro");
				diaCookie.setMaxAge(60*60*24*7);
    			response.addCookie(diaCookie);
    			response.sendRedirect(request.getRequestURI());
    		}
    			
    		String orden="";
    		if(request.getParameter("num")!=null) {
    			if(request.getParameter("num").equalsIgnoreCase("1")) {
    				orden="ORDER BY nombre";
    			}else if(request.getParameter("num").equalsIgnoreCase("2")){
    				orden="ORDER BY nombre DESC";
    			}
    		}
    		
    		Cookie cookie2 = buscarCookie("dia", request);
        	if (cookie2 != null) 
        		dia=cookie2.getValue();
        	
        	if(request.getParameter("nombre")!=null) {
    			String nom=request.getParameter("nombre");
    			String consulta2 = "SELECT nombre, origen, dia FROM actuacion WHERE dia="+dia+" AND nombre LIKE '%"+nom+"%' "+orden;
    			ResultSet rset2 = sentencia.executeQuery(consulta2);

    			if (!rset2.isBeforeFirst() ) {    
    				out.println("<h3>No hay resultados</p>");
    			}

    			out.println("<table style='border:'5px''>");
    			out.println("<tr style='background-color:green'><td>Nombre del artista</a>"
    					+ "<a href=MostrarCartel?num=1>&#9650;</a><a href=MostrarCartel?num=2>&#9660;</a></td>"
    					+ "<td>País de origen</td></tr>");
    			while (rset2.next()) {
    				out.println("<tr style='background-color:orange'>");
    				out.println("<td>"+rset2.getString("nombre")+"</td><td>"+rset2.getString("origen")+"</td></tr>");}
    			out.println("</table>");

    		} else {
    			String consulta3="SELECT id, nombre, origen, dia FROM actuacion WHERE dia="+dia+" "+orden;
        		ResultSet rset3= sentencia.executeQuery(consulta3);
        		if (!rset3.isBeforeFirst() )   
    				out.println("<h3>No hay resultados</p>");
        		out.println("<h2>Mostrando el día "+dia+"</h2>");
    			out.println("<table style='border:'5px''>");
    			out.println("<tr style='background-color:green'><td>Nombre del artista</a>"
    					+ "<a href=MostrarCartel?num=1>&#9650;</a><a href=MostrarCartel?num=2>&#9660;</a></td>"
    					+ "<td>País de origen</td></tr>");
    			while (rset3.next()) {
    				out.println("<tr style='background-color:orange'>");
    				out.println("<td><a href=MostrarActuacion?idActuacion="+rset3.getString("id")+">"+rset3.getString("nombre")+"</a></td><td>"+rset3.getString("origen")+"</td></tr>");
    			}
    			out.println("</table>");
    		}
    		
			out.println("<form action='MostrarCartel' method='post'><br/>");
    		out.println("<label>Buscar actuación: </label>");
    		out.println("<input type='text' name='nombre'>");
    		out.println("<input type='submit' value='Enviar' name='enviar'>");
    		out.println("</form>");
    		
    		if (sentencia != null)
    			sentencia.close();
    		if (conn != null)
    			conn.close();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	out.print("<a href=MostrarCartel>Eliminar filtros</a></br>");
    	out.println("<a href=Principal>Principal</a>");
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
