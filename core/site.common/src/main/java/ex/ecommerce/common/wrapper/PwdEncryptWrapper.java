package ex.ecommerce.common.wrapper;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class PwdEncryptWrapper extends HttpServletRequestWrapper {

	private String data;

	public PwdEncryptWrapper(final HttpServletRequest request) throws IOException {
		super(request);

		final InputStream inputStream = request.getInputStream();
		
		if(inputStream != null) {
			
			try(final BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

				String json = br.readLine();

				final ObjectMapper om = new ObjectMapper();
				
				final JsonNode node = om.readValue(json, JsonNode.class);
				
				final String pwd = node.get("pwd").toString();
				
				final String pwdEncrypt = BCrypt.withDefaults().hashToString(12, pwd.toCharArray());
				
				((ObjectNode)node).put("pwd", pwdEncrypt); 		
				
				this.data = node.toString();
				
			} catch(IOException e) {
				throw e;
			}
			
		}

	}
	
	@Override
	public ServletInputStream getInputStream() throws IOException {
		
		final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.data.getBytes());

		final ServletInputStream servletInputStream = new ServletInputStream() {

			@Override
			public boolean isFinished() {
				return false;
			}

			@Override
			public boolean isReady() {
				return false;
			}

			@Override
			public void setReadListener(ReadListener arg) {
			}

			@Override
			public int read() throws IOException {
				return byteArrayInputStream.read();
			}
			
		};
		
		return servletInputStream;
	}
	
	@Override
	public BufferedReader getReader() throws IOException {
		return new BufferedReader(new InputStreamReader(this.getInputStream()));
	}
	
	@Override
	public ServletRequest getRequest() {
		return super.getRequest();
	}

}