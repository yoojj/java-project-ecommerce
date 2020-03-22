package ex.ecommerce.admin.util;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import ex.ecommerce.common.util.MailUtil;
import ex.ecommerce.common.vo.Mail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:config/common-context.xml", 
		"classpath*:config/mail-context.xml"})
@WebAppConfiguration
public class MailUtilTest {
	
	@Test
	public void test() {
		
		String html = "<p style='color:red'>test</p>";
		
		final Mail mail = new Mail();
		
		mail.setToMail(""); 
		
		mail.setGroupMail(new String[] {"", ""});
		mail.setGroupMailHide(new String[] {""});

		mail.setMailSubject("mail subject");
		mail.setMailHTMLContent(html);
		
		boolean result = MailUtil.sendMail(mail);
		
		System.out.println(result);

	}
	
}