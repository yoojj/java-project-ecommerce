package ex.ecommerce.admin.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.UrlPathHelper;

import ex.ecommerce.common.constant.SessionConstant;
import ex.ecommerce.common.util.LoggerUtil;

public class AdminLoginCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) 
			throws Exception{
		
		LoggerUtil.log.info(">>> 관리자 로그인 확인 인터셉터 ");

		if ( request.getSession().getAttribute(SessionConstant.ADMIN_KEY) == null ){ 

			if(this.isUrlAccess(request)) {
				return true;	

			} else {
				
				PrintWriter out = response.getWriter();
				
				response.setContentType("text/html;charset=UTF-8");
				out.println("<script>");
				out.println("alert('로그인이 필요합니다.');");
				out.println("window.location.href = window.location.origin + '/' + "
						+ "window.location.pathname.split('/')[1] + '/login' ");
				out.println("</script>");
				out.close();  
				
				return false;
			}
			
		} else if ( request.getSession().getAttribute(SessionConstant.ADMIN_KEY) != null ){ 
		
			if(this.isUrlAccess(request)) {

				response.sendRedirect("main");
				return false;
				
			} else {
				return true;
			}
			
		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, 
			ModelAndView model) throws Exception {
		super.postHandle(request, response, object, model);
	}
	
	private boolean isUrlAccess(HttpServletRequest request) {
		
		final UrlPathHelper urlHelper = new UrlPathHelper();
		
		final String url = urlHelper.getPathWithinApplication(request);
		
		if(url.equals("/login")) {
			return true;
			
		} else if(url.equals("/ajax.adminLogin")) {
			return true;
		}
		
		return false;
	}

}