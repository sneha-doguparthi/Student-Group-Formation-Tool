package CSCI5308.GroupFormationTool.Profile.DAO;

public class ProfileDaoFactory extends ProfileDaoAbstractFactory {

	private static ProfileDaoFactory instance = null;
	private IOtpDao otpDao;
	private IPasswordHistoryDao passwordHistoryDao;
	private IRoleDao roleDao;
	private IUserDao userDao;

	private ProfileDaoFactory() {
	}

	public static ProfileDaoFactory instance() {
		if (null == instance) {
			instance = new ProfileDaoFactory();
		}
		return instance;
	}

	@Override
	public IOtpDao otpDao() {
		if (null == otpDao) {
			otpDao = new OtpDaoImpl();
		}
		return otpDao;
	}

	@Override
	public IPasswordHistoryDao passwordHistoryDao() {
		if (null == passwordHistoryDao) {
			passwordHistoryDao = new PasswordHistoryDaoImpl();
		}
		return passwordHistoryDao;
	}

	@Override
	public IRoleDao roleDao() {
		if (null == roleDao) {
			roleDao = new RoleDaoImpl();
		}
		return roleDao;
	}

	@Override
	public IUserDao userDao() {
		if (null == userDao) {
			userDao = new UserDaoImpl();
		}
		return userDao;
	}

}
