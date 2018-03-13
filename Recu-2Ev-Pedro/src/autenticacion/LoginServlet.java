package autenticacion;
import modelo.Usuario;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/Login")
@WebFilter(filterName="FiltroDeRegistro")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletContext contexto = getServletContext();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;UTF-8");
		String mensajeError = "";
		Connection conn = null;
		Statement sentencia = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver").newInstance();

			String userName = "alumno";
			String password = "alumno";
			String url = "jdbc:mariadb://localhost/ps2013";
			conn = DriverManager.getConnection(url, userName, password);

			sentencia = conn.createStatement();

			if ((session.getAttribute("login") != null)) { 
					//response.sendRedirect(contexto.getContextPath() + "/"); 
					response.sendRedirect("./Principal"); 
				}
			else if (request.getMethod().equals("POST")) {
				mensajeError = "";
				if (request.getParameter("username").equals("alumno") && request.getParameter("password").equals("alumno")) {
					String nombre = request.getParameter("username");
					String contraseña = request.getParameter("username");
					Usuario user=new Usuario(nombre, contraseña);
					session.setAttribute("login", user);
					response.sendRedirect("/");
				}
				else {
					mensajeError = "Usuario no válido.";
				}
						
			}
		
			out.println("<html><head><meta charset='UTF-8'/></head><body>");
	    	out.println("<h1>Primavera Sound</h1>");
	    	out.println("<img src='./img/portada.jpg'>");
			out.println("<h3>Inicia sesión:</h3>");
			out.println("<form action='" + request.getRequestURI() + "' method='post'>"
					+ "<label>Usuario:</label><input type='text' name='username'><br/>"
					+ "<label>Contraseña:</label><input type='password' name='password'><br/>"
					+ "<input type='submit' value='Iniciar sesión' name='enviar'>" 
					+ "</form>" + "<p><a href='"
					+ contexto.getContextPath() + "/Alta'>Haz clic para registrarte</a></p>"
					+ "<h3>" + mensajeError + "</h3>");

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

}
