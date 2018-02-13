package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcesarDatosServlet
 */
@WebServlet("/ProcesarDatos")
public class ProcesarDatosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcesarDatosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<html><head><meta charset='UTF-8'/><title>Procesar datos</title></head>");
        out.println("<body><h1>Datos del formulario</h1>");
        out.println("<h3>Nombre: Valor</h3>");
       
        out.println("<ul>");
        out.println("<li>Nombre: "+request.getParameter("text")+"</li>");
        
        out.println("<li>Contraseña: "+request.getParameter("pass")+"</li>");
        
        out.println("<li>Numero: "+request.getParameter("number")+"</li>");
        	
        out.println("<li>Fecha: "+request.getParameter("date")+"</li>");
        
        String[] valoresRadio=request.getParameterValues("radio");
        for(int i=0;i<valoresRadio.length; i++)
        	out.println("<li>Radio: "+valoresRadio[i]+"</li>");
        
        out.println("<li>Checkbox:</li>");

        out.println("<ul>");
        String[] valoresCheckbox=request.getParameterValues("checkbox");
        for(int i=0;i<valoresCheckbox.length; i++)
        	out.println("<li>"+valoresCheckbox[i]+"</li>");
        out.println("</ul>");
        
        out.println("</ul>");
       
        out.println("<a href='./index.html'>Volver</a>");
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
