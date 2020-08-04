package ex.ecommerce.admin.interceptor;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;

import ex.ecommerce.common.module.result.CodeEnum;
import ex.ecommerce.common.module.result.Result;
import ex.ecommerce.common.util.IPUtil;
import ex.ecommerce.common.util.LoggerUtil;

public class AdminIPCheckInterceptor extends HandlerInterceptorAdapter {

	// 임시 
	// 별도 클래스로 분리  
	// DB에서 데이터를 받아오게 수정 
	final List<String> IP_LIST = Arrays.asList("14.102.128.0", "103.146.230.0");
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) 
			throws Exception{
		
		LoggerUtil.log.info(">>> 관리자 아이피 확인 인터셉터 ");

		final String ip = IPUtil.getIP(request);

		final boolean isAccess = IP_LIST.contains(ip);

		if (isAccess == true){ 

			final Result result = new Result();
			
			result.setCode(CodeEnum.ERROR.getCode());
			result.setMessage("접근이 제한된 IP 입니다.");

			final ObjectMapper om = new ObjectMapper();
			final String json = om.writeValueAsString(result);

			response.setContentType("application/json");
			response.getWriter().write(json);

			return false;
		}

		request.setAttribute("ip", ip);
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, 
			ModelAndView model) throws Exception {
		super.postHandle(request, response, object, model);
	}

}