package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class ContadorFilter
 */
//@WebFilter("/ContadorFilter")
@WebFilter(filterName="FiltroContador")
public class ContadorFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ContadorFilter() {
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
		//ServletContext contexto = request.getServletContext();
		ServletContext contexto=request.getServletContext();
		int numero=0;
		
		if(contexto.getAttribute("numero")!=null) {
			numero=Integer.parseInt((contexto.getAttribute("numero")).toString())+1;
			contexto.setAttribute("numero", numero);
		}else {
			contexto.setAttribute("numero", numero);
		}
		
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
