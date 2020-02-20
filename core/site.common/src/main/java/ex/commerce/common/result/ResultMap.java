package ex.commerce.common.result;

import java.util.HashMap;

@SuppressWarnings("serial")
public class ResultMap extends HashMap<String, Object> {

	public void add(String key, Object value){
		this.put(key, value);
	}
	
}