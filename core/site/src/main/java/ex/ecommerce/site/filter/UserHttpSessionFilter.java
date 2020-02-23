package ex.ecommerce.site.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ex.ecommerce.common.constant.SessionConstant;
import ex.ecommerce.common.util.LoggerUtil;

@WebFilter
public class UserHttpSessionFilter implements Filter {

	@Override
	public void init(FilterConfig config) throws ServletException {}
	
	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpSession session = ((HttpServletRequest) request).getSession(false);
		
		if ( session == null )
			session = ((HttpServletRequest) request).getSession(true);
		
		LoggerUtil.log.info(">>> 회원 세션 필터 :  " + session.getId() );
		LoggerUtil.log.info(">>> 회원 세션 필터 :  " + session.getAttribute(SessionConstant.USER_KEY));

		chain.doFilter( request, response );
		
	}

}