package ex.ecommerce.admin.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import ex.ecommerce.common.constant.SessionConstant;
import ex.ecommerce.common.util.LoggerUtil;

public class AdminLoginCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) 
			throws Exception{
		
		LoggerUtil.log.info(">>> 관리자 로그인 확인 인터셉터 : " + request.getSession().getAttribute(SessionConstant.ADMIN_KEY) );
		LoggerUtil.log.info(">>> 관리자 로그인 확인 인터셉터 : " + request.getSession().getId() );

		if ( request.getSession().getAttribute(SessionConstant.ADMIN_KEY) == null ){ 

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

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, 
			ModelAndView model) throws Exception {
		super.postHandle(request, response, object, model);
	}

}