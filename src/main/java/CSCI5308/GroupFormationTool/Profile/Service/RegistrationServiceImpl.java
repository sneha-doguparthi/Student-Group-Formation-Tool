package CSCI5308.GroupFormationTool.Profile.Service;

import CSCI5308.GroupFormationTool.Model.User;
import CSCI5308.GroupFormationTool.Profile.DAO.PasswordHistoryDao;
import CSCI5308.GroupFormationTool.Profile.DAO.PasswordHistoryDaoImpl;
import CSCI5308.GroupFormationTool.Profile.DAO.UserDao;
import CSCI5308.GroupFormationTool.Profile.DAO.UserDaoImpl;

public class RegistrationServiceImpl implements RegistrationService {

	public boolean registerUserService(User u) {
		UserDao userDao = new UserDaoImpl();
		PasswordHistoryDao passwordHistoryDao = new PasswordHistoryDaoImpl();

		boolean userInsert = userDao.registerUser(u);
		boolean historyInsert = passwordHistoryDao.insert(u.getEmail(), u.getPassword());

		return userInsert && historyInsert;
	}
}
