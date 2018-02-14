package servlets;

import java.io.IOException;
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
			
		if(request.getParameter("lado")!="") {
			Cuadrado c=new Cuadrado(Color.Amarillo, Integer.parseInt(request.getParameter("lado")));
		}
		if(request.getParameter("ladoX")!="" && request.getParameter("ladoY")!="") {
			Rectangulo r=new Rectangulo(Color.Amarillo, Integer.parseInt(request.getParameter("ladoX")), Integer.parseInt(request.getParameter("ladoY")));
		}
		
		if(request.getParameter("radio")!="") {
			Circunferencia c=new Circunferencia(Color.Amarillo, Integer.parseInt(request.getParameter("radio")));
		}
		if(request.getParameter("radioX")!="" && request.getParameter("radioY")!="") {
			Elipse e=new Elipse(Color.Amarillo, Integer.parseInt(request.getParameter("radioX")), Integer.parseInt(request.getParameter("radioY")));
		}
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*switch (sw) {
		case "lado":break;
		case "ladoX": case "ladoX": break;
		case "radio": break;
		case "radioX":case "radioY":break;
		}*/
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
