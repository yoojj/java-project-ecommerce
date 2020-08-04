package ex.ecommerce.admin.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

@WebListener
public class AdminBindingListener implements HttpSessionBindingListener {

	/**
	 * 중복 로그인 방지 클래스   
	 * 
	 * - HttpSessionBindingListener 세션 바인딩 및 언바인딩시 이벤트 
	 * - HttpSessionListener 세션 생성 및 해제시 이벤트 
	 */

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
	}

}