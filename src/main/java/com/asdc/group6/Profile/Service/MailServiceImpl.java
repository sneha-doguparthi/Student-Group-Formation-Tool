package com.asdc.group6.Profile.Service;

import java.util.Properties;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class MailServiceImpl implements MailService {

	@Override
	public Boolean sendMail(String email, String subject, String text) {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		
		// configuration for mail host url and port
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		  
		// credentials for mail sender account
		mailSender.setUsername("dalmcproject@gmail.com");
		mailSender.setPassword("ccsezaisrrtwpdzh");
		  
		// setting properties for mail sender
		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth","true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");
		  
		// creating message structure for mail to send
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setSubject(subject);
		message.setText(text);
		
		mailSender.send(message);
		
		return true;
	}
}
