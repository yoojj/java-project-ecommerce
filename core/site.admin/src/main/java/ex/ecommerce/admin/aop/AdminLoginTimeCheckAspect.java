package ex.ecommerce.admin.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AdminLoginTimeCheckAspect {

	/**
	 * 관리자 로그인시 마지막 로그인 시간을 확인해 
	 * 일정 기간이 지났다면 로그인을 제한하고 
	 * 임시 비밀 번호를 발급하는 페이지로 이동하는 클래스  
	 */
	
	
}