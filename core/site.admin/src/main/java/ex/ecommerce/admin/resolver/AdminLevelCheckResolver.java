package ex.ecommerce.admin.resolver;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import ex.ecommerce.admin.annotation.AdminLevelCheck;
import ex.ecommerce.admin.module.member.Admin;

public class AdminLevelCheckResolver implements HandlerMethodArgumentResolver {

	/**
	 * 
	 * 
	 */
	
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.hasParameterAnnotation(AdminLevelCheck.class);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

		final Admin admin = new Admin();
		
		final HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
		
		return admin;
	}

}