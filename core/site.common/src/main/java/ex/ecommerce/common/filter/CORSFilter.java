package ex.ecommerce.common.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

@WebFilter(urlPatterns="/*", filterName="secondFilter")
public class CORSFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, 
			FilterChain chain) throws ServletException, IOException {
		
		String origin = request.getHeader("origin");
		
		origin = (origin==null || origin.equals("")) ? "null" : origin;
		
		// addHeader : 헤더가 존재할 경우 값 추가 
		// setHeader : 헤더가 존재할 경우 기존 값 overwrite
		
		response.setHeader("Access-Control-Allow-Origin", origin );
		response.setHeader("Access-Control-Allow-Headers", "*" );
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, DELETE, OPTIONS");
		response.setHeader("Access-Control-Max-Age", "3600");
		
		chain.doFilter(request, response);
	
	}

}