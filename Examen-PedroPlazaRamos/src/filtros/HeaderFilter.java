package filtros;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class HeaderFilter
 */
@WebFilter("/HeaderFilter")
public class HeaderFilter implements Filter {

    /**
     * Default constructor. 
     */
    public HeaderFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request; 
	    HttpServletResponse res = (HttpServletResponse) response; 
	    ServletContext contexto = request.getServletContext(); 
	    String uri = req.getRequestURI();
	    if(uri.endsWith(".jpg") || uri.endsWith(".gif") || uri.endsWith(".css")){     
	        chain.doFilter(request, response);
	    }else {
			response.setContentType("text/html;UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<html><head><meta charset='UTF-8'/>"
					+ "<title>Supermercado de Pedro</title></head><body>");
			out.println("<img src='./img/supermercado1.jpg'>");
			chain.doFilter(request, response);
	    }
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
