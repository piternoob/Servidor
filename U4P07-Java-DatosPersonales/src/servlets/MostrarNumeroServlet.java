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
@WebServlet("/VerNumero")
public class MostrarNumeroServlet extends HttpServlet {
 
    private static final long serialVersionUID = 1L;
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Enumeration <String> atributos= request.getAttributeNames();
        if(!atributos.hasMoreElements())
            response.sendRedirect("./index.html");
        else {
        	response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<html><head><meta charset='UTF-8'/><title>Atributo request</title></head>"
                    + "<style>table,td {border:solid 1px black;}</style></head>");
            out.println("<body><h1>Numero</h1>");
        	out.println("<p>Nombre: "+request.getAttribute("nom")+".</p>");
        	out.println("<p style='color:"+request.getAttribute("color")+"'>"+request.getAttribute("dig")+"</p>");
        	out.println("<a href='./index.html'>Volver</a>");
            
            out.close();
        }
        
        
        
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}