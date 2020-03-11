package ex.ecommerce.site.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserLoginTimeCheckAspect {

	/**
	 * 유저 로그인시 마지막 로그인 시간을 확인해 
	 * 일정 기간이 지났다면 비밀 번호를 바꾸는 페이지로 이동하는 클래스 
	 */
	
}