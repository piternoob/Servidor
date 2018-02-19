package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MostrarFiguraServlet
 */
@WebServlet("/MostrarFiguraServlet")
public class MostrarFiguraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarFiguraServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	Enumeration <String> atributos= request.getAttributeNames();
    	if(!atributos.hasMoreElements())
    		response.sendRedirect("./index.html");
    	else {
    		response.setContentType("text/html;charset=UTF-8");
    		PrintWriter out = response.getWriter();
    		out.println("<html><head><meta charset='UTF-8'/><title>Atributo request</title></head>"
    				+ "<style>table,td {border:solid 1px black;}</style></head>");
    		out.println("<body><h1>Figura</h1>");
    		out.println("<p>Nombre: "+request.getAttribute("tipo")+".</p>");
    		out.println("<p style='color:"+request.getAttribute("color")+"'>"+request.getAttribute("dig")+"</p>");
    		out.println("<a href='./index.html'>Volver</a>");

    		out.close();
    	}
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
