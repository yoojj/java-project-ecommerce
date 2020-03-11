package ex.ecommerce.admin.listener;
import java.util.Hashtable;
import java.util.Map;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

@WebListener
public class AdminBindingListener implements HttpSessionBindingListener {

	/**
	 * 중복 로그인 방지 클래스   
	 */

	private static Map<HttpSession, String> loginAdmin = new Hashtable<>();
	
	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {

	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {

	}

}