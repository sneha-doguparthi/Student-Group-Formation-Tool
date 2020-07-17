package CSCI5308.GroupFormationTool.Course.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import CSCI5308.GroupFormationTool.Model.Student;
import CSCI5308.GroupFormationTool.Utilities.ApplicationConstants;

public class SendInvitationEmailServiceImpl implements ISendInvitationEmailService {
	Logger logger = LogManager.getLogger(SendInvitationEmailServiceImpl.class);

	@Override
	public boolean sendUserInvitationEmail(List<Student> newToPortalList, ArrayList<String> passwords) {
		JavaMailSenderImpl mailSender = initializeMailSender();
		SimpleMailMessage message = new SimpleMailMessage();
		int listSize = newToPortalList.size();

		for (int i = 0; i < listSize; i++) {
			message.setTo(newToPortalList.get(i).getEmail());
			message.setSubject("Registration to a Group-6 Project Portal");
			message.setText("Welcome " + newToPortalList.get(i).getFirstName() + " to our Portal! [Group-6 Project]\n\n"
					+ "Here are your credentials:\n" + "Email: " + newToPortalList.get(i).getEmail() + "\n"
					+ "Password: " + passwords.get(i));
			mailSender.send(message);
		}
		logger.info("User registration invitation mail sent.");
		return true;
	}

	@Override
	public boolean sendCourseInvitationEmail(List<Student> newToCourseList, String courseCode, String courseName) {

		JavaMailSenderImpl mailSender = initializeMailSender();
		SimpleMailMessage message = new SimpleMailMessage();
		int listSize = newToCourseList.size();

		for (int i = 0; i < listSize; i++) {
			message.setTo(newToCourseList.get(i).getEmail());
			message.setSubject("Registration to a new course - " + courseName);
			message.setText("Welcome " + newToCourseList.get(i).getFirstName() + " to your new course " + courseCode
					+ "! " + courseName);
			mailSender.send(message);
		}
		logger.info("Course invitation mail sent to the users.");
		return true;
	}

	private JavaMailSenderImpl initializeMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(ApplicationConstants.MAIL_HOST);
		mailSender.setPort(ApplicationConstants.MAIL_PORT);
		mailSender.setUsername(ApplicationConstants.MAIL_SENDER_ID);
		mailSender.setPassword(ApplicationConstants.MAIL_SENDER_PASSWORD);

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");
		return mailSender;
	}
}
