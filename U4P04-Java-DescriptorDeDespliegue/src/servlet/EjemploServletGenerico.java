package servlet;

import java.io.IOException;
 
import javax.servlet.GenericServlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

//@WebServlet(urlPatterns="/EjemploServletGenerico", loadOnStartup=1)
public class EjemploServletGenerico extends GenericServlet {
      private static final long serialVersionUID = 1L;
 
  public void service(ServletRequest req, ServletResponse res) throws IOException {
	  log("Petición recibida desde " + req.getRemoteAddr());
      res.setContentType("text/html");
      res.getWriter().println("<html><head><meta charset='UTF-8'/></head>");
      res.getWriter().println("<body><h1>Mensaje desde el servlet genérico de ejemplo</h1>");
      res.getWriter().println("<a href='./index.html'>Volver</a>");
      res.getWriter().println("</body></html>");
      res.getWriter().close();
  }
  
  public void init() {
	  log("Iniciando el servlet genérico");
  }
  
  public void destroy() {
	  log("Destruyendo el servlet genérico");
  }
	 
  public String getServletInfo() {
	  return "Servlet de Ejemplo usando GenericServlet";
	}
  
}