package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidarSorpresaServlet
 */
@WebServlet("/ValidarSorpresa")
public class ValidarSorpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidarSorpresaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
       
        boolean nombre=false, numero=false, color=false;
        String nm="", col="";
        int num=-1;
        
        //nombre
        if(request.getParameter("nomb")!="") {
        	nombre=true;
        	nm=request.getParameter("nomb");
        }
        	
        
        //numero
        if(request.getParameter("max")!=""){
            num=Integer.parseInt(request.getParameter("max"));
			if(num>0)
				numero=true;
		}
        
        //color
        if(request.getParameter("color")!="") {
        	color=true;
        	col=request.getParameter("color");
        }
        
        if(nombre && numero && color) {
        	int a=(int)(Math.random()*num);
        	request.setAttribute("nom", nm);
        	request.setAttribute("dig", a);
            request.setAttribute("color", request.getParameter("color"));
        
            RequestDispatcher rd=request.getRequestDispatcher("VerNumero");
            rd.forward(request, response);
            
            
        } else {
        	response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
        	out.println("<p>Los datos no son correctos.</p>");
        	out.println("<a href='./index.html'>Volver</a>");
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
