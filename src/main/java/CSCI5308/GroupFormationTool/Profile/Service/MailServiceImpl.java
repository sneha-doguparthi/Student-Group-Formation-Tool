package CSCI5308.GroupFormationTool.Profile.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class MailServiceImpl implements IMailService {

	private static Logger logger = LogManager.getLogger(MailServiceImpl.class);

	@Override
	public Boolean sendMail(String email, String subject, String text) {

		String applicationConfigFile = "application.properties";
		InputStream applicationPropertiesStream = MailServiceImpl.class.getClassLoader()
				.getResourceAsStream(applicationConfigFile);
		Properties applicationProperties = new Properties();
		try {
			applicationProperties.load(applicationPropertiesStream);
		} catch (IOException e) {
			logger.error("Exception occurred while loading application.properties file ", e);
		}

		String host = applicationProperties.getProperty("mail.host");
		String port = applicationProperties.getProperty("mail.port");
		String username = applicationProperties.getProperty("mail.username");
		String password = applicationProperties.getProperty("mail.password");

		String protocol = applicationProperties.getProperty("prop.protocol");
		String auth = applicationProperties.getProperty("prop.auth");
		String starttls = applicationProperties.getProperty("prop.starttls");
		String debug = applicationProperties.getProperty("prop.debug");

		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

		mailSender.setHost(host);
		mailSender.setPort(Integer.parseInt(port));
		mailSender.setUsername(username);
		mailSender.setPassword(password);

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", protocol);
		props.put("mail.smtp.auth", auth);
		props.put("mail.smtp.starttls.enable", starttls);
		props.put("mail.debug", debug);

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setSubject(subject);
		message.setText(text);

		mailSender.send(message);

		return true;
	}

}
