package CSCI5308.GroupFormationTool.Profile.Service;

public interface MailService {

	Boolean sendMail(String email, String subject, String text);

}
