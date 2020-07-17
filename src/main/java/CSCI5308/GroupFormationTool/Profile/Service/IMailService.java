package CSCI5308.GroupFormationTool.Profile.Service;

public interface IMailService {

	public Boolean sendMail(String email, String subject, String text);

}
