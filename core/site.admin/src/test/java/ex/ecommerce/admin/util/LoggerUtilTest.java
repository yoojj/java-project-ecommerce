package ex.ecommerce.admin.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import ex.ecommerce.common.util.LoggerUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/common-context.xml"})
@WebAppConfiguration
public class LoggerUtilTest {

	@Test
	public void test() {
		
		LoggerUtil.log.info(">> info");
		LoggerUtil.log.warn(">> warn");
		LoggerUtil.log.error(">> error");
		
	}
	
}