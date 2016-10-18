package pro.niit.petshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailService {

	@Autowired
	private MailSender mail; 
	// MailSender interface defines a strategy
	// for sending simple mails
 
	public void sendEmail(String toAddress, String fromAddress, String subject, String body) {
 
		SimpleMailMessage mailMsg = new SimpleMailMessage();
		mailMsg.setFrom(fromAddress);
		mailMsg.setTo(toAddress);
		mailMsg.setSubject(subject);
		mailMsg.setText(body);
		mail.send(mailMsg);
		
	}
}
