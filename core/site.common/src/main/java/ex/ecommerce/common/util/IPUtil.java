package ex.ecommerce.common.util;

import javax.servlet.http.HttpServletRequest;

public final class IPUtil {

	public static String getIP(HttpServletRequest request) {
		
		System.setProperty("java.net.preferIPv4Stack" , "true");
		
		String ip = request.getHeader("X-Forwarded-For");
		// String realIp = request.getHeader("X-Real-IP");
		
		if( ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip) ) {
			ip = request.getHeader("Proxy-Client-IP");
		}

		if( ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip) ) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}

		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}

		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}

		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}

		return ip;
	}

}