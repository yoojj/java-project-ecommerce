package ex.ecommerce.admin.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import ex.ecommerce.common.constant.AdminLevelEnum;

public class AdminServletContextListener implements ServletContextListener {

	/**
	 * 웹 애플리케이션 시작시 관리자 등급 데이터 전송  
	 */
	
	@Override
	public void contextInitialized(ServletContextEvent e) {

		final ServletContext context = e.getServletContext();
		
		context.setAttribute("adminLevelEnum", AdminLevelEnum.values());

	}
	
	@Override
	public void contextDestroyed(ServletContextEvent e) {
	}

}