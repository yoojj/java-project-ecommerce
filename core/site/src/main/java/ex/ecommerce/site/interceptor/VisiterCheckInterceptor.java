package ex.ecommerce.site.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import ex.ecommerce.common.constant.SessionConstant;
import ex.ecommerce.common.util.LoggerUtil;

public class VisiterCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) 
			throws Exception{
		
		LoggerUtil.log.info(">>> 로그인 확인 인터셉터");

		if (request.getSession().getAttribute(SessionConstant.USER_KEY) == null){ 
			return true;
		}
		
		final PrintWriter out = response.getWriter();
		
		response.setContentType("text/html;charset=UTF-8");
		out.println("<script>");
		out.println("location.href = location.origin + '/' + location.pathname.split('/')[1] + '/'");
		out.println("</script>");
		out.close();   

		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, 
			ModelAndView model) throws Exception {
		super.postHandle(request, response, object, model);
	}
	
}