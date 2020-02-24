package ex.ecommerce.common.util;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import ex.ecommerce.common.vo.Mail;

@Component
public final class MailUtil {

	private static JavaMailSender mailSender;

	@Autowired
	private JavaMailSender getMailSender;

	@PostConstruct
	public void init() {
		MailUtil.mailSender = getMailSender;
	}

	public static boolean sendMail(final Mail mail) {

		MimeMessage message = null;
		MimeMessageHelper messageHelper = null;

		try {
			
			message = mailSender.createMimeMessage();
			messageHelper = new MimeMessageHelper(message, false, "UTF-8");

			messageHelper.setTo( mail.getToMail() );
			
			if(mail.getGroupMail() != null){
				messageHelper.setTo( mail.getGroupMail() );
			}

			if(mail.getGroupMailHide() != null){
				messageHelper.setBcc( mail.getGroupMailHide() );
			}
			
			messageHelper.setSubject( mail.getMailSubject() );

			if(mail.getMailContent() != null) {
				messageHelper.setText( mail.getMailContent() );
			}
			
			if(mail.getMailHTMLContent() != null) {
				message.setContent( mail.getMailHTMLContent(), "text/html; charset=utf-8" );				
			} 

			if(mail.getMailFile() != null && mail.getMailFileName() != null) {
				messageHelper.addAttachment( mail.getMailFileName(), mail.getMailFile() );
			}

		} catch(MailSendException | MessagingException e) {
			
			LoggerUtil.log.error(e.getMessage());
			
			return false;

		}
		
		mailSender.send(message);
		
		return true;
	}

}