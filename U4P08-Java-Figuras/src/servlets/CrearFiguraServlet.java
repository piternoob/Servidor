package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import figuras.*;

/**
 * Servlet implementation class CrearFiguraServlet
 */
@WebServlet("/CrearFigura")
public class CrearFiguraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearFiguraServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tipo="";
		boolean swL=false, swR=false;
		
		if(request.getParameter("ladoX")!="" || request.getParameter("ladoY")!="") swL=true;
		
		if(request.getParameter("radioX")!="" || request.getParameter("radioY")!="" ) swR=true;

		if(swL || swR) {

			if(request.getParameter("ladoX")!="" && request.getParameter("ladoY")=="" && !swR) tipo="Cuadrado";
				else if (request.getParameter("ladoX")!="" && request.getParameter("ladoY")!="" && !swR) tipo="Rectangulo";

			if(request.getParameter("radioX")!="" && request.getParameter("radioY")=="" && !swL) tipo="Circunferencia";
				else if(request.getParameter("radioX")!="" && request.getParameter("radioY")!="" && !swL) tipo="Elipse";

			if(tipo!="") {
				request.setAttribute("tipo", tipo);
				RequestDispatcher rd=request.getRequestDispatcher("MostrarFigura");
				rd.forward(request, response);
			} else 
				response.sendRedirect("./index.html");
		
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
