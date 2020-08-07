package ex.ecommerce.admin.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import ex.ecommerce.admin.annotation.AdminLevelCheck;
import ex.ecommerce.admin.module.member.AdminSessionDTO;
import ex.ecommerce.common.constant.SessionConstant;
import ex.ecommerce.common.util.LoggerUtil;

public class AdminLevelCheckInterceptor extends HandlerInterceptorAdapter {

	/**
	 * 관리자 등급에 따라 특정 페이지 접근 금지 
	 * 
	 * 1. interceptor.xml 접근 불가능한 url 정의 
	 * 2. @AdminLevelCheck(level) 접근 불가능한 클래스나 메소드 정의 
	 */

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) 
			throws Exception{
		
		LoggerUtil.log.info(">>> 관리자 등급 확인 인터셉터 ");

		if((object instanceof HandlerMethod) == false){
			return true;
		}
		
		final HandlerMethod handlerMethod = (HandlerMethod) object;
		
		final AdminLevelCheck annotationClass = handlerMethod.getMethod().getDeclaringClass().getAnnotation(AdminLevelCheck.class);
		
		final AdminLevelCheck annotationMethod = handlerMethod.getMethodAnnotation(AdminLevelCheck.class);
		
		final AdminSessionDTO admin = (AdminSessionDTO) request.getSession().getAttribute(SessionConstant.ADMIN_KEY);
		
		boolean checkResult = false;
		
		// 임시 
		// 어노테이션에 정의된 조건과 관리자 레벨이 같은 경우만 접근 가능
		if(annotationClass != null) {
			checkResult = annotationClass.level().getNum() == admin.getLevel();
			
		} else if(annotationMethod != null) {
			checkResult = annotationMethod.level().getNum() == admin.getLevel();
			
		} else {
			checkResult = true;
		}

		if(checkResult == false) {
		
			final PrintWriter out = response.getWriter();
			
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('접근 불가능합니다.');");
			out.println("location.href = location.origin + '/' + location.pathname.split('/')[1]");
			out.println("</script>");
			out.close();  
			
		}
		
		return checkResult;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, 
			ModelAndView model) throws Exception {
		super.postHandle(request, response, object, model);
	}
	
}