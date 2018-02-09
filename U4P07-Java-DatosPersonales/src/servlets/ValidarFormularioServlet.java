package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidarFormularioServlet
 */
@WebServlet("/ValidarFormulario")
public class ValidarFormularioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidarFormularioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nombre, contraseña, mayusculas;
		
        PrintWriter out = response.getWriter();
       
        if(request.getParameter("text")!=null)
        	nombre=request.getParameter("text");
        else
        	nombre="El campo está vacío.";
        	
        out.println("<li>Contraseña: "+request.getParameter("pass")+"</li>");
        if(request.getParameter("pass")!=null)
        	if(request.getParameter("pass").length()>=8) {
        		contraseña=request.getParameter("pass");
        		for(int i=0; i<contraseña.length();i++) {
        			if(Character.isDigit(contraseña.charAt(i)))
        				contraseña+="";
        		}
        		
        	}else
        		contraseña="La contraserña debe tener mínimo 8 caracteres y al menos una mayuscula y un numero.";
        else
        	contraseña="La contraserña debe tener mínimo 8 caracteres y al menos una mayuscula y un numero.";

        out.println("<li>Numero: "+request.getParameter("number")+"</li>");

        out.println("<li>Fecha: "+request.getParameter("date")+"</li>");
        
        String[] valoresRadio=request.getParameterValues("radio");
        for(int i=0;i<valoresRadio.length; i++)
        	out.println("<li>Radio: "+valoresRadio[i]+"</li>");
        
        out.println("<li>Checkbox:</li>");
        String[] valoresCheckbox=request.getParameterValues("checkbox");
        for(int i=0;i<valoresCheckbox.length; i++)
        	out.println("<li>"+valoresCheckbox[i]+"</li>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
