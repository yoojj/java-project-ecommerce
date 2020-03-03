package ex.ecommerce.common.valid;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Valid implements Serializable {

	private String min;
	private String max;
	private String pattern;
	
	public Valid() {
		super();
	}
	
	public Valid(String min) {
		super();
		this.min = min;
	}

	public Valid(String min,  String pattern) {
		super();
		this.min = min;
		this.pattern = pattern;
	}

	public Valid(String min, String max, String pattern) {
		super();
		this.min = min;
		this.max = max;
		this.pattern = pattern;
	}

	public String getMin() {
		return min;
	}
	
	public void setMin(String min) {
		this.min = min;
	}
	
	public String getMax() {
		return max;
	}
	
	public void setMax(String max) {
		this.max = max;
	}
	
	public String getPattern() {
		return pattern;
	}
	
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

}