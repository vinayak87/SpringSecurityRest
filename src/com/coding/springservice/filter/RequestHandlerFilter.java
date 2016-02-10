package com.coding.springservice.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class RequestHandlerFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		String uri = ((HttpServletRequest) request).getRequestURI();
		String pathInfo = ((HttpServletRequest) request).getPathInfo();
		System.out.println("pathInfo "+pathInfo);
		if (uri.endsWith(".jsp")||uri.endsWith(".js") ) {
		    chain.doFilter(request, response); // Just let it go (assuming that files are in real not placed in a /spring folder!)
		} else if (uri.endsWith("search")){
		    request.getRequestDispatcher("/counter-api/search").forward(request, response); // Pass to Spring dispatcher servlet.
		}else if (uri.contains("top")){
			request.getRequestDispatcher("/counter-api"+pathInfo).forward(request, response); 
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
