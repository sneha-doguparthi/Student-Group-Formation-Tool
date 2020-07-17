package CSCI5308.GroupFormationTool.Profile.Service;

public abstract class ProfleServiceAbstractFactory {
	public abstract ILoginService loginService();

	public abstract IMailService mailService();

	public abstract IOtpService otpService();

	public abstract IRegistrationService registrationService();
}
