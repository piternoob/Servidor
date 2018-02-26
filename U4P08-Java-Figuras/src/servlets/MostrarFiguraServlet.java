package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import figuras.*;

/**
 * Servlet implementation class MostrarFiguraServlet
 */
@WebServlet("/MostrarFigura")
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
    		response.setContentType("text/html;charset=UTF-8");
    		PrintWriter out = response.getWriter();
    		out.println("<html><head><meta charset='UTF-8'/><title>Atributo request</title></head>");
    		out.println("<body><h1>Figura</h1>");
    		if(request.getAttribute("error")!=null) {
    			out.println("<p>"+request.getAttribute("error")+"</h1>");
    		}
    		if(request.getAttribute("figura")!=null) {
    			out.println("<p>"+request.getAttribute("figura").toString()+"</p>");
    		}
    		
    		out.println("<a href='./index.html'>Volver</a>");
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
