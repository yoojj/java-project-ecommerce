package ex.ecommerce.site.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class UserHttpSessionListener implements HttpSessionListener, HttpSessionAttributeListener  {

	@Override
	public void sessionCreated(HttpSessionEvent event) {

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {

	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {

	}

}