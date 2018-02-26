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
		boolean sw=false;
		int ladoX=-1, ladoY=-1, radioX=-1,radioY=-1;
		Figura f=null;
		
		if(request.getParameter("ladoX")!="") ladoX=Integer.parseInt(request.getParameter("ladoX")); 
		if(request.getParameter("ladoY")!="") ladoY=Integer.parseInt(request.getParameter("ladoY")); 
		if(request.getParameter("radioX")!="") radioX=Integer.parseInt(request.getParameter("radioX")); 
		if(request.getParameter("radioY")!="") radioY=Integer.parseInt(request.getParameter("radioY"));
		
		if(sw) {if(ladoX!=-1 && ladoY==-1 && radioX==-1 && radioY==-1) f=new Cuadrado(Color.Amarillo, ladoX);
			if(ladoX!=-1 && ladoY!=-1 && radioX==-1 && radioY==-1) f=new Rectangulo(Color.Amarillo, ladoX, ladoY);
			if(ladoX==-1 && ladoY==-1 && radioX!=-1 && radioY==-1) f=new Circunferencia(Color.Amarillo, radioX);
			if(ladoX==-1 && ladoY==-1 && radioX!=-1 && radioY!=-1) f=new Elipse(Color.Amarillo, radioX, radioY);
		}
		if(f!=null) request.setAttribute("figura", f);
			else request.setAttribute("error", "No se puede crear la figura.");
		RequestDispatcher rd=request.getRequestDispatcher("MostrarFigura");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	
	

}
