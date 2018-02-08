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
@WebServlet("/MostrarNumero")
public class MostrarNumeroServlet extends HttpServlet {
 
    private static final long serialVersionUID = 1L;
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><head><meta charset='UTF-8'/><title>Atributo request</title></head>"
                + "<style>table,td {border:solid 1px black;}</style></head>");
        out.println("<body><h1>Numero</h1>");
        
        Enumeration <String> atributos= request.getAttributeNames();
        if(!atributos.hasMoreElements())
            //response.sendRedirect("./index.html");
        	response.sendRedirect("./Sorpresa");
        else {
        	int numero=(int) request.getAttribute("numero");
        	int[] colores=(int[]) request.getAttribute("colores");
        	out.println("<p style='color:rgb("+colores[0]+","+colores[1]+", "+colores[2]+");'>"+numero+"</p>");
        }
        /*else {
        	int[] array= new int [3];
        	int i=0;
        	while(atributos.hasMoreElements()) {
        		array[i]=atributos.
        	}
        	out.println("<p color='rgb("+a+","+b+", "+c+")'>"+request.getAttribute("numero")+"</p>");
        }*/
        out.println("<a href='./index.html'>Volver</a>");
        
        out.close();
        
    }
}