package ex.ecommerce.admin;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import ex.ecommerce.common.util.LoggerUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:config/root-context.xml", 
		"classpath*:config/app/*.xml"})
@WebAppConfiguration
public class MailTest {

	@Autowired
	private JavaMailSender mailSender;
	
	@Value("#{mail['mail.username']}")
	private String mail;
	
	@Test
	public void test() {
	
		MimeMessage message = null;
		MimeMessageHelper messageHelper = null;
		
		try {
			
			message = mailSender.createMimeMessage();
			messageHelper = new MimeMessageHelper(message, false, "UTF-8");
			
			messageHelper.setFrom(mail);
			messageHelper.setTo("");
			messageHelper.setSubject("mail subject");
			messageHelper.setText("mail content");
			
		} catch(MailSendException | MessagingException e) {
			
			LoggerUtil.log.error(e.getMessage());
			
		}
			
		mailSender.send(message);
		
	}
	
}