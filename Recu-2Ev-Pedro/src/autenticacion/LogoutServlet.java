package autenticacion;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
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
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
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
		response.setContentType("text/html;UTF-8");
		String mensajeError = "";
		Connection conn = null;
		Statement sentencia = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver").newInstance();

			String username = "alumno";
			String password = "alumno";
			String url = "jdbc:mariadb://localhost/ps2013";
			conn = DriverManager.getConnection(url, username, password);

			sentencia = conn.createStatement();

			if ((session.getAttribute("login") != null)) { 
					//response.sendRedirect(contexto.getContextPath() + "/"); 
					response.sendRedirect("./Principal"); 
				}
			else if (request.getMethod().equals("POST")) {
				mensajeError = "";
				if (request.getParameter("username").equals("alumno") && request.getParameter("password").equals("alumno")) {
					session.invalidate();
		    		session=request.getSession();
				}
				else {
					mensajeError = "Usuario no válido.";
				}
						
			}
		
			out.println("<html><head><meta charset='UTF-8'/></head><body>");
	    	out.println("<h1>Primavera Sound</h1>");
	    	out.println("<img src='./img/portada.jpg'>");
	    	
			out.println("<h3>Introduce tus datos para cerrar sesión:</h3>");
			out.println("<form action='" + request.getRequestURI() + "' method='post'>"
					+ "<label>Usuario:</label><input type='text' name='username'><br/>"
					+ "<label>Contraseña:</label><input type='password' name='password'><br/>"
					+ "<input type='submit' value='Iniciar sesión' name='enviar'>" 
					+ "</form><h3>" + mensajeError + "</h3>");

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
