package ex.ecommerce.common.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;

public final class MediaTypeUtil {

	private static Map<String, MediaType> MEDIA_TYPE;

	public static MediaType getImage() {
		
		MEDIA_TYPE = new HashMap<String, MediaType>();
		
		MEDIA_TYPE.put("gif", MediaType.IMAGE_GIF);
		MEDIA_TYPE.put("jpg", MediaType.IMAGE_JPEG);
		MEDIA_TYPE.put("png", MediaType.IMAGE_PNG);
		
		return (MediaType) MEDIA_TYPE;
	}
	
}