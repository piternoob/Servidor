package servlets.cuenta;
import modelo.Usuario;

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

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
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
		HttpSession session = request.getSession(false); // L1
		ServletContext contexto = getServletContext();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;UTF-8");
		String mensajeError = "";
		// si ya había sesión con un valor de usuario válido
		Connection conn = null;
		Statement sentencia = null;
		try {
			// Paso 1: Cargar el driver JDBC.
			Class.forName("org.mariadb.jdbc.Driver").newInstance();

			// Paso 2: Conectarse a la Base de Datos utilizando la clase Connection
			String userName = contexto.getInitParameter("usr_db_r");
			String password = contexto.getInitParameter("psw_db_r");
			String url = contexto.getInitParameter("srv_db")+"/catalogo10";
			conn = DriverManager.getConnection(url, userName, password);

			// Paso 3: Crear sentencias SQL, utilizando objetos de tipo Statement
			sentencia = conn.createStatement();

			if (session != null) {
				if ((session.getAttribute("login") != null)) {
					response.sendRedirect(contexto.getContextPath() + "/MostrarCatalogo");
				}
			} else {
				if (request.getMethod().equals("POST")) { 
					mensajeError = "";
					if (request.getParameter("login") == "") {
						mensajeError = "Usuario vacio";
					} else {
						if (request.getParameter("password") == "") {
							mensajeError = "Contraseña vacia";
						} else {
							if (request.getParameter("login") != "") {

								String consulta = "SELECT * FROM usuario where usuario.login LIKE '" + request.getParameter("username") + "'";
								ResultSet rset = sentencia.executeQuery(consulta);
								if (!rset.isBeforeFirst()) {
									mensajeError = "Usuario no valido";
								} else {
									rset.next();

									if (!rset.getString("password").equals(request.getParameter("password"))) {
										mensajeError = "Contraseña no valida";
									} else {
										String login = rset.getString("login");
										String pas = rset.getString("password");
										String nombre = rset.getString("nombre");
										int admin = rset.getInt("admin");
										String descripcion = rset.getString("descripcion");
										if (admin == 1) {
											session = request.getSession();

											Usuario user = new Usuario(login, pas, nombre,true, descripcion );
											session.setAttribute("usuario", user);
											contexto.log("Crear sesion " + request.getRequestURI());
											response.sendRedirect(contexto.getContextPath() + "/MostrarCatalogo");

										} else {
											session = request.getSession();

											Usuario user = new Usuario(login, pas, nombre, false,descripcion );
											session.setAttribute("usuario", user);
											contexto.log("Crear sesion " + request.getRequestURI());
											response.sendRedirect(contexto.getContextPath() + "/MostrarCatalogo");

										}
									}

								}
							}
						}
					}

				}

			out.println("<html><head><meta charset='UTF-8'/>" 
                        + "<style> .error {color: red}</style>"
                        + "<title>Catálogo de Pedro Plaza Ramos</title></head><body>");
			out.println("<h3>Inicio de sesión</h3>");
			out.println("<form action='" + request.getRequestURI() + "' method='post'>"
					+ "<label>Usuario:</label><input type='text' name='username'><br/>"
					+ "<label>Contraseña:</label><input type='password' name='password'><br/>"
					+ "<input type='submit' value='Iniciar sesión' name='enviar'>" 
                    + "</form>" + "<p><a href='"
					+ contexto.getContextPath() + "/Alta'>¿Aún no estás registrado? Haz clic en este enlace</a></p>"
					+ "<h3>" + mensajeError + "</h3>");

			}


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
