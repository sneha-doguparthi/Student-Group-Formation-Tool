package CSCI5308.GroupFormationTool.Profile.DAO;

public abstract class ProfileDaoAbstractFactory {
	public abstract IOtpDao otpDao();

	public abstract IPasswordHistoryDao passwordHistoryDao();

	public abstract IRoleDao roleDao();

	public abstract IUserDao userDao();
}
