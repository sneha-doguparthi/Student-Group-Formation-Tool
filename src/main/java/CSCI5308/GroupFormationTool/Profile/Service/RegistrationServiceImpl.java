package CSCI5308.GroupFormationTool.Profile.Service;

import CSCI5308.GroupFormationTool.Profile.IUser;
import CSCI5308.GroupFormationTool.Profile.DAO.IPasswordHistoryDao;
import CSCI5308.GroupFormationTool.Profile.DAO.IUserDao;
import CSCI5308.GroupFormationTool.Profile.DAO.ProfileDaoFactory;

public class RegistrationServiceImpl implements IRegistrationService {

	public boolean registerUserService(IUser u) {
		IUserDao userDao = ProfileDaoFactory.instance().userDao();
		IPasswordHistoryDao passwordHistoryDao = ProfileDaoFactory.instance().passwordHistoryDao();

		boolean userInsert = userDao.registerUser(u);
		boolean historyInsert = passwordHistoryDao.insert(u.getEmail(), u.getPassword());

		return userInsert && historyInsert;
	}

}
