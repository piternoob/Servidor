package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GenerarNumeroServlet
 */
@WebServlet("/GenerarColores")public class GenerarColoresServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Enumeration <String> atributos= request.getAttributeNames();
		if(!atributos.hasMoreElements())
			//response.sendRedirect("./index.html");
			response.sendRedirect("./Sorpresa");
		else {
			int a=(int)(Math.random()*256);
			//request.setAttribute("color1", a);
			int b=(int)(Math.random()*256);
			//request.setAttribute("color2", b);
			int c=(int)(Math.random()*256);
			//request.setAttribute("color3", c);
			int[] array= {a,b,c};
			request.setAttribute("colores", array);
			
			RequestDispatcher rd=request.getRequestDispatcher("MostrarNumero");
			rd.forward(request, response);

		}
	}





}

