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
		int ladoX=0, ladoY=0, radioX=0,radioY=0;
		Figura f=null;
		Color color=null;
		String mensaje="";
		
		
		
		if(request.getParameter("ladoX")!=null) ladoX=Integer.parseInt(request.getParameter("ladoX")); 
		if(request.getParameter("ladoY")!=null) ladoY=Integer.parseInt(request.getParameter("ladoY")); 
		if(request.getParameter("radioX")!=null) radioX=Integer.parseInt(request.getParameter("radioX")); 
		if(request.getParameter("radioY")!=null) radioY=Integer.parseInt(request.getParameter("radioY"));
		
		switch (request.getParameter("color")) {
			case "Amarillo": color=Color.Amarillo; break;
			case "Azul": color=Color.Azul; break;
			case "Naranja": color=Color.Naranja; break;
			case "Rojo": color=Color.Rojo; break;
			case "Verde": color=Color.Verde; break;
		}
		
		if(ladoX!=0 && ladoY==0 && radioX==0 && radioY==0) f=new Cuadrado(color, ladoX);
		if(ladoX!=0 && ladoY!=0 && radioX==0 && radioY==0) f=new Rectangulo(color, ladoX, ladoY);
		if(ladoX==0 && ladoY==0 && radioX!=0 && radioY==0) f=new Circunferencia(color, radioX);
		if(ladoX==0 && ladoY==0 && radioX!=0 && radioY!=0) f=new Elipse(color, radioX, radioY);
		
		if(f!=null) request.setAttribute("figura", f);
			else request.setAttribute("error", "Error al crear la figura");
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
	
	
	public int crearInts(HttpServletRequest request,int valor) {
		
		if(request.getParameter(valor)!=null) ladoX=Integer.parseInt(request.getParameter("ladoX")); 
		
		return valor;
	}
	

}
