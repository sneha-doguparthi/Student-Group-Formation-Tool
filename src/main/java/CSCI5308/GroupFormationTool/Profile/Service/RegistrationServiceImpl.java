package CSCI5308.GroupFormationTool.Profile.Service;

import CSCI5308.GroupFormationTool.Model.User;
import CSCI5308.GroupFormationTool.Profile.DAO.PasswordHistoryDao;
import CSCI5308.GroupFormationTool.Profile.DAO.UserDao;
import CSCI5308.GroupFormationTool.SystemConfig;

public class RegistrationServiceImpl implements RegistrationService {

	public boolean registerUserService(User u) {
		UserDao userDao = SystemConfig.instance().getUserDao();
		PasswordHistoryDao passwordHistoryDao = SystemConfig.instance().getPasswordHistoryDao();

		boolean userInsert = userDao.registerUser(u);
		boolean historyInsert = passwordHistoryDao.insert(u.getEmail(), u.getPassword());

		return userInsert && historyInsert;
	}

}
