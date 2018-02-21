package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SaludoServlet
 */
@WebServlet("/Saludo")
public class SaludoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaludoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		String mensaje="";

		if (request.getParameter("reiniciarSesion")!=null) {
    		session.invalidate();
    		session=request.getSession();
		}
		
		if(request.getMethod().equals("POST")) {
			if(request.getParameter("usuario")!="") 
				session.setAttribute("usuario", request.getParameter("usuario"));
			else
				mensaje="El campo de usuario esta vacío.";
		}

		PrintWriter out = response.getWriter();
		response.setContentType("text/html;UTF-8");
		out.println("<html><head><meta charset='UTF-8'/>" + "<style> .error {color: red}</style>"
				+ "<title>Sesiones en JavaEE</title></head><body>");
		if(session.getAttribute("usuario")!=null) {
			out.println("<h2>Hola "+session.getAttribute("usuario")+"</h2>");
		} else {
			out.println("<form action='"+request.getRequestURI()+"' method='POST'>"
					+ "<label>Introduce tu nombre para dirigirnos a ti:</label>" + "<input type='text' name='usuario'/>"
					+ "<span class='error'>" + mensaje + "</span><br/>"
					+ "<input type='submit' name='enviar' value='Enviar'/></form>");
		}
		if(mensaje!="")
			out.println("<h2 class='error'>"+mensaje+"</h2>");
		out.println("<p><a href='" + request.getRequestURI() + "'>Refrescar</a></p>");
		out.println("<p><a href='" + request.getRequestURI() + "?reiniciarSesion=true'>Borrar la sesión</a></p>");
		out.println("</body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
