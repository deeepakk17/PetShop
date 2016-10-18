/* */

/*package pro.niit.petshop.controller;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pro.niit.petshop.service.VerificationEmailAPI;

public class Test {

	@SuppressWarnings("resource")
	public static void main(String args[]) {
 
		// Spring Bean file you specified in /src/main/resources folder
		String mailSenderConfFile = "mailSender-bean.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(mailSenderConfFile);
 
		// @Service("verificationEmailAPI") <-- same annotation you specified in VerificationMailAPI.java
		VerificationEmailAPI verificationEmailAPI  = (VerificationEmailAPI) context.getBean("verificationEmail");
		String toAddr = "deeepakk17@gmail.com";
		String fromAddr = "shoppet24@gmail.com";
 
		// email subject
		String subject = "Hey.. This email sent by Petshop's Email check";
 
		// email body
		String body = "There you go.. You got an email.. ";
		verificationEmailAPI.ReadyToSendEmail(toAddr, fromAddr, subject, body);
	}
	
	
	


}*/