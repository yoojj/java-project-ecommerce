package ex.ecommerce.common.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public final class DateUtil {

	public static LocalDateTime getLocalDateTime() {
		final LocalDateTime nowDateTime = LocalDateTime.now();
		return nowDateTime;
	}
	
	public static String getDateTime() {
		return getLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}
	
	public static String getDate() {
		final LocalDate date = getLocalDateTime().toLocalDate();
		return date.toString();
	}
	
	public static String getTime() {
		final LocalTime time = getLocalDateTime().toLocalTime();
		return time.toString();
	}
	
	public static String getTime(String format) {
		final String time = getLocalDateTime().toLocalTime().format(DateTimeFormatter.ofPattern(format));
		return time;
	}
	
}