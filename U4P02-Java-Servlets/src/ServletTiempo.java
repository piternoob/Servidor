

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletTiempo
 */
@WebServlet("/ServletTiempo")
public class ServletTiempo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTiempo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Date date=new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		//System.out.println("Hora y fecha: "+hourdateFormat.format(date));
		response.setContentType("text/html;UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><head><meta charset='UTF-8'/><title>Segundo Servlet</title></head>");
        out.println("<body><h1>Primer servlet</h1>");
        out.println("<h3>Me llamo ...</h3>");
        out.println("<p>Fecha y hora " + hourdateFormat.format(date) + "</p>");
        out.println("<a href='index.html'>Volver</a>");
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
