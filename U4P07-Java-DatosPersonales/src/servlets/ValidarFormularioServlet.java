package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.jrockit.jfr.parser.ParseException;

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
		
		String nombre, contraseña, mayusculas="ABCDEFGHIJKLMNÑOPQRSTVWXYZ";
		boolean mayus=false, num=false;
		
        PrintWriter out = response.getWriter();
       
        //nombre
        if(request.getParameter("text")!=null) {
        	nombre=request.getParameter("text");
        	 out.println("<li>Nombre: "+nombre+"</li>");
        }else{
        	nombre="El campo está vacío.";
        	out.println("<li>Nombre: "+nombre+"</li>");
        }
        
        //pass
        if(request.getParameter("pass")!=null)
        	if(request.getParameter("pass").length()>=8) {
        		contraseña=request.getParameter("pass");
        		for(int i=0; i<contraseña.length() && (!mayus || !num);i++) {
        			if(Character.isDigit(contraseña.charAt(i)))
        				num=true;
        			else
        				for(int j=0; j<mayusculas.length() && !mayus; j++) {
        					if(mayusculas.charAt(j)==contraseña.charAt(i))
        						mayus=true;
        				}
        		}
        		if(num && mayus)
        			contraseña=request.getParameter("pass");
        		else
        			contraseña="La contraserña debe tener mínimo 8 caracteres y al menos una mayuscula y un numero.";
        	}else
        		contraseña="La contraserña debe tener mínimo 8 caracteres y al menos una mayuscula y un numero.";
        else
        	contraseña="La contraserña debe tener mínimo 8 caracteres y al menos una mayuscula y un numero.";

        out.println("<li>Contraseña: "+contraseña+"</li>");
        
        //numero
        out.println("<li>Numero: "+request.getParameter("number")+"</li>");

        
        //fecha
        SimpleDateFormat formatoFechaFormulario=new SimpleDateFormat("yyyy-MM-dd");
        try {
        	Date fecha= formatoFechaFormulario.parse(request.getParameter("fecha"));
        	SimpleDateFormat formatoFechaSalida=new SimpleDateFormat("dd/MM/yyyy");
        	out.println("<li>Fecha: "+formatoFechaSalida.format(fecha)+"</li>");
        } catch (Exception e) {
        	e.printStackTrace();
		}
        out.println("<li>Fecha: "+request.getParameter("date")+"</li>");
        
        String[] valoresRadio=request.getParameterValues("radio");
        for(int i=0;i<valoresRadio.length; i++)
        	out.println("<li>Radio: "+valoresRadio[i]+"</li>");
        
        out.println("<li>Checkbox:");
        String[] valoresCheckbox=request.getParameterValues("checkbox");
        for(int i=0;i<valoresCheckbox.length; i++)
        	out.println(valoresCheckbox[i]+", ");
        out.println("</li>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
