package CSCI5308.GroupFormationTool.Profile.Service;

public class ProfileServiceFactory extends ProfleServiceAbstractFactory {

	private static ProfileServiceFactory instance = null;
	private ILoginService loginService;
	private IMailService mailService;
	private IOtpService otpService;
	private IRegistrationService registrationService;

	private ProfileServiceFactory() {
	}

	public static ProfileServiceFactory instance() {
		if (null == instance) {
			instance = new ProfileServiceFactory();
		}
		return instance;
	}

	@Override
	public ILoginService loginService() {
		if (null == loginService) {
			loginService = new LoginServiceImpl();
		}
		return loginService;
	}

	@Override
	public IMailService mailService() {
		if (null == mailService) {
			mailService = new MailServiceImpl();
		}
		return mailService;
	}

	@Override
	public IOtpService otpService() {
		if (null == otpService) {
			otpService = new OtpServiceImpl();
		}
		return otpService;
	}

	@Override
	public IRegistrationService registrationService() {
		if (null == registrationService) {
			registrationService = new RegistrationServiceImpl();
		}
		return registrationService;
	}

}
