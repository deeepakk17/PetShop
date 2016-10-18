package pro.niit.petshop.handler;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import pro.niit.petshop.dao.UserDAO;
import pro.niit.petshop.model.OTP;
import pro.niit.petshop.model.UserDetails;
import pro.niit.petshop.service.MailService;
import pro.niit.petshop.service.UserService;

@Component
public class UserHandler {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDAO userDAO;

	public UserDetails initFlow() {
		return new UserDetails();
	}

	public String validateDetails(UserDetails userDetails, MessageContext messageContext) {
		
		List<UserDetails> userList = null;
		userList = userService.list();
		
		String status = "success";
		if (userDetails.getUsername().isEmpty()) {
			messageContext.addMessage(
					new MessageBuilder().error().source("username").defaultText("Username cannot be Empty").build());
			status = "failure";
		}
		if (userDetails.getFirstname().isEmpty()) {
			messageContext.addMessage(
					new MessageBuilder().error().source("firstname").defaultText("Firstname cannot be Empty").build());
			status = "failure";
		}
		if (userDetails.getLastname().isEmpty()) {
			messageContext.addMessage(
					new MessageBuilder().error().source("lastname").defaultText("Lastname cannot be Empty").build());
			status = "failure";
		}
		if (userDetails.getEmail().isEmpty()) {
			messageContext.addMessage(new MessageBuilder().error().source("email")
					.defaultText("email cannot be Empty").build());
			status = "failure";
		}
		if (userDetails.getMobilenumber().isEmpty()) {
			messageContext.addMessage(new MessageBuilder().error().source("mobilenumber")
					.defaultText("Mobilenumber cannot be Empty").build());
			status = "failure";
		}
		if (userDetails.getPassword().isEmpty()) {
			messageContext.addMessage(
					new MessageBuilder().error().source("password").defaultText("Password cannot be Empty").build());
			status = "failure";
		}
		if (userDetails.getConfirmpassword().isEmpty()) {
			messageContext.addMessage(new MessageBuilder().error().source("confirmpassword")
					.defaultText("Confirmpassword cannot be Empty").build());
			status = "failure";
		}
		/*if(userList !=  null){
		    for (int i=0; i < userList.size(); i++){
		        if(userDetails.getUsername() == userList.get(i).getUsername()){            
		        	messageContext.addMessage(new MessageBuilder().error().source("username")
							.defaultText("Username already exists").build());
					status = "failure";
		        }
		        if(userDetails.getEmail() == userList.get(i).getUsername()){            
		        	messageContext.addMessage(new MessageBuilder().error().source("email")
							.defaultText("Email already exists").build());
					status = "failure";
		        }
		    }
		    
		}*/
		return status;
	}

	public String generateOTP() {
		String chars = "0123456789";
		final int PW_LENGTH = 6;
		Random rnd = new SecureRandom();
		StringBuilder pass = new StringBuilder();
		for (int i = 0; i < PW_LENGTH; i++)
			pass.append(chars.charAt(rnd.nextInt(chars.length())));
		return pass.toString();
	}

	public OTP sendMail(UserDetails userDetails) {

		
		// Spring Bean file you specified in /src/main/resources folder
		String mailSenderConfFile = "mailSender-bean.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(mailSenderConfFile);

		// @Service("mailService") <-- same annotation you specified in MailService.java
		MailService mailService = (MailService) context.getBean("mailService");

		String toAddr = userDetails.getEmail();
		String fromAddr = "shoppet24@gmail.com";

		// email subject
		String subject = "Welcome to Petshop.com";
		OTP otp = new OTP();
		String password = generateOTP();
		otp.setEmail(userDetails.getEmail());
		otp.setOtp(password);
		userService.saveOrUpdate(otp);
		
		// email body
		String body = "Hello.. Enter this OTP to Register your account OTP: " + password;
		mailService.sendEmail(toAddr, fromAddr, subject, body);
		
		return new OTP();
	}

	public void saveDetails(UserDetails userDetails) {
		userService.saveOrUpdate(userDetails);

	}
	
public String verifyotp(OTP oTP,UserDetails userDetails,MessageContext messageContext) {
	String status = "failure";
	OTP existingOTP= userDAO.getOtp(userDetails.getEmail());
	if (oTP.getOtp().equals(existingOTP.getOtp())) {
		messageContext.addMessage(
				new MessageBuilder().error().source("otp").defaultText("Enter Correct OTP").build());
		status = "success";
	}
	return status;
}

}
