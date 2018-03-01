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
import javax.servlet.http.HttpSession;

import modelo.Usuario;



/**
 * Servlet implementation class MostrarMercadoServlet
 */
@WebServlet("/MostrarMercado")
public class MostrarMercadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarMercadoServlet() {
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
		Connection conn = null;
    	Statement sentencia = null;
    	Usuario usuario = (Usuario) session.getAttribute("usuario");
		
    	response.setContentType("text/html;UTF-8");
    	out.println("<h1>Sesión iniciada como <a href='"+contexto.getContextPath()+"/Cuenta'>" + usuario.getNombre() + "</a></h1>");
		
    	
    	
    	Cookie cookie;
    	String actual="";
    	
    	if(request.getParameter("f")!=null) {
    		String leeloptm=request.getParameter("f");
   			cookie = new Cookie("fam", leeloptm);
    		cookie.setMaxAge(60*60*24);
    		response.addCookie(cookie);
    		response.sendRedirect(request.getRequestURI());
		}
    	cookie = buscarCookie("fam", request);
    	String familia=null;
    	if (cookie != null) {
    		
    		familia="WHERE familia="+cookie.getValue()+";";
    		actual=cookie.getValue();
    	}else {
    		familia="WHERE familia=Bio;";
    		actual="Bio";
    	}
    	
    	
    	try {
    		Class.forName("org.mariadb.jdbc.Driver").newInstance();

    		String userName = "alumno";
    		String password = "alumno";
    		String url = "jdbc:mariadb://localhost/supermercado";
    		conn = DriverManager.getConnection(url, userName, password);

    		sentencia = conn.createStatement();

    		String cons = "SELECT DISTINCT familia from producto";
    		ResultSet rse = sentencia.executeQuery(cons);
    		
    		if (!rse.isBeforeFirst() ) {    
    			out.println("<h3>No hay resultados</p>");
    		}
    		out.println("<ul>");
    		while (rse.next()) {
    			out.println("<li><a href=MostrarMercado?f="+rse.getString("familia")+">"+rse.getString("familia") + "</a></li>");
			}
    		out.println("</ul>");
    		
    		out.println("<h1>Se esta mostrando la familia "+actual+"</h1>");
    		
    		String orden="";
    		if(request.getParameter("num")!=null) {
    			if(request.getParameter("num").equalsIgnoreCase("1")) {
    				orden="ORDER BY nombre;";
    			}else if(request.getParameter("num").equalsIgnoreCase("2")){
    				orden="ORDER BY nombre DESC;";
    			}else if(request.getParameter("num").equalsIgnoreCase("3")){
    				orden="ORDER BY marca;";
    			}else if(request.getParameter("num").equalsIgnoreCase("4")){
    				orden="ORDER BY marca DESC;";
    			}
    		}

    		String consulta = "SELECT * from producto "+familia+" AND "+orden;
    		ResultSet rset = sentencia.executeQuery(consulta);

    		if (!rset.isBeforeFirst() ) {    
    			out.println("<h3>No hay resultados</p>");
    		}


    		if(request.getParameter("nombre")!=null) {
    			String nombre=request.getParameter("nombre");
    			String consulta2 = "SELECT * from producto WHERE nombre LIKE '%"+nombre+"%'";
    			ResultSet rset2 = sentencia.executeQuery(consulta2);

    			if (!rset2.isBeforeFirst() ) {    
    				out.println("<h3>No hay resultados</p>");
    			}

    			out.println("<table style='border:'5px''>");
    			out.println("<tr style='background-color:green'><td>Nombre</td><td>Marca</td><td>Imagen</td></tr>");
    			while (rset2.next()) {
    				out.println("<tr style='background-color:orange'>");
    				out.println("<td>" + rset2.getString("nombre") + "</td><td> " + rset2.getString("marca") + "</td><td><img src='./img/productos/"+rset.getString("imagen")+"'></td></tr>");
    			}
    			out.println("</table>");

    		}else {

    			out.println("<table style='border:'5px''>");
    			out.println("<tr style='background-color:green'><td>Nombre<a href=MostrarMercado?num=1>&#9650;</a><a href=MostrarMercado?num=2>&#9660;</a></td>"
    					+ "<td>Marca<a href=MostrarMercado?num=3>&#9650;</a><a href=MostrarMercado?num=4>&#9660;</a></td>"
    					+ "<td>Imagen</td></tr>");
    			while (rset.next()) {
    				out.println("<tr style='background-color:orange'>");
    				out.println("<td>" +"<a href=MostrarProducto?idProd='"+rset.getString("idproducto")+"'>"+rset.getString("nombre") + "</td><td>"+rset.getString("marca")+"</td><td><img src='./img/productos/"+rset.getString("imagen")+"'></td></tr>");
    			}
    			out.println("</table>");

    		}

    		out.println("<form action='MostrarMercado' method='post'><br/>");
    		out.println("<label>Buscar por nombre: </label>");
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
