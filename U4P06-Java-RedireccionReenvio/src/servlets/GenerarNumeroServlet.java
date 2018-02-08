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
@WebServlet("/Sorpresa")public class GenerarNumeroServlet extends HttpServlet {
 
    private static final long serialVersionUID = 1L;
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><head><meta charset='UTF-8'/><title>Variables servidor</title></head>"
                + "<style>table,td {border:solid 1px black;}</style></head>");
        out.println("<body><h1>Reedirección y envío</h1>");
        request.setAttribute("random", Math.random()*100);
        out.println("<h1>"+request.getAttribute("random")+"</h1>");
 
        out.println("<a href='./index.html'>Volver</a>");
        out.close();*/
        
        int a=(int)(Math.random()*100);
        request.setAttribute("numero", a);
    
        RequestDispatcher rd=request.getRequestDispatcher("GenerarColores");
        rd.forward(request, response);
        
        //response.sendRedirect("./MostrarNumero");
  
        
    }
}
