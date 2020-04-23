package ex.ecommerce.admin.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import ex.ecommerce.common.constant.AdminLevelEnum;

public class AdminServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {

		final ServletContext context = event.getServletContext();
		
		context.setAttribute("adminLevelEnum", AdminLevelEnum.values());

	}
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
	}

}