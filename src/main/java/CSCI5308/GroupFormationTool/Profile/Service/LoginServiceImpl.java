package CSCI5308.GroupFormationTool.Profile.Service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import CSCI5308.GroupFormationTool.Model.User;
import CSCI5308.GroupFormationTool.Profile.DAO.UserDao;
import CSCI5308.GroupFormationTool.Profile.DAO.UserDaoImpl;

public class LoginServiceImpl implements LoginService {

	public String checkAccessService(User user, Model model) {

		UserDao userDao = new UserDaoImpl();

		ArrayList<User> list = userDao.getByEmail(user.getEmail());

		// No user found with provided email or incorrect passowrd
		if (list.size() == 0 || !list.get(0).getPassword().equals(user.getPassword()))
			return "profile/login";

		// Getting the data of valid user from database
		User loggedInUser = list.get(0);
		// If user type is admin then redirect to admin page
		if (loggedInUser.getUserType().equals("A")) {
			return "redirect:/admin/admin-home?userId=" + loggedInUser.getUserId();
		} else {
			return "redirect:/courses/home?userId=" + loggedInUser.getUserId();
		}
	}
}
