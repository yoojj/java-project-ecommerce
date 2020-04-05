package ex.ecommerce.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import ex.ecommerce.common.wrapper.PwdEncryptWrapper;

@WebFilter
public class PwdEncryptionFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		PwdEncryptWrapper wrapper = new PwdEncryptWrapper((HttpServletRequest) request);

		chain.doFilter(wrapper, response);
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
	}

}