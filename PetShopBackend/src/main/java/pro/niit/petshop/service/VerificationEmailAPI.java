/*package pro.niit.petshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service("verificationEmail")
public class VerificationEmailAPI {	

	@Autowired
	private MailSender mail; 
	// MailSender interface defines a strategy
	// for sending simple mails
 
	public void ReadyToSendEmail(String toAddress, String fromAddress, String subject, String msgBody) {
 
		SimpleMailMessage mailMsg = new SimpleMailMessage();
		mailMsg.setFrom(fromAddress);
		mailMsg.setTo(toAddress);
		mailMsg.setSubject(subject);
		mailMsg.setText(msgBody);
		mail.send(mailMsg);
		
	}
}
*/