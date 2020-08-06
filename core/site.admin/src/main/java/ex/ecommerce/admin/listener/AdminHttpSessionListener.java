package ex.ecommerce.admin.listener;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import ex.ecommerce.admin.module.member.AdminSessionDTO;
import ex.ecommerce.common.constant.SessionConstant;

@WebListener
public class AdminHttpSessionListener implements HttpSessionListener, HttpSessionAttributeListener {

	/**
	 * 중복 로그인 방지 클래스   
	 * 
	 * - HttpSessionListener 세션 생성 및 해제시 이벤트 
	 * - HttpSessionBindingListener 세션 바인딩 및 언바인딩시 이벤트 
	 */

	

	public static Map<String, HttpSession> LOGIN_ADMIN_LIST = Collections.synchronizedMap(new HashMap<>());
	
	public static boolean isAdminLogin(String id) { 

		if(LOGIN_ADMIN_LIST.containsKey(id) == true){
			return true;
		}
		
		return false;
	}
	
	public static void removeKey(String id) {
		LOGIN_ADMIN_LIST.remove(id);
	}
	
	@Override
	public void sessionCreated(HttpSessionEvent event) {
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {

		final HttpSession session = event.getSession();
		
		final AdminSessionDTO admin = (AdminSessionDTO) session.getAttribute(SessionConstant.ADMIN_KEY);

		LOGIN_ADMIN_LIST.put(admin.getId(), session);

	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
	}
	
}