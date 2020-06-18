package CSCI5308.GroupFormationTool.Profile.Service;

import CSCI5308.GroupFormationTool.Model.User;
import CSCI5308.GroupFormationTool.Profile.DAO.UserDao;
import CSCI5308.GroupFormationTool.SystemConfig;
import org.springframework.ui.Model;

import java.util.ArrayList;

public class LoginServiceImpl implements LoginService {

	public String checkAccessService(String email, Model model) {

		UserDao userDao = SystemConfig.instance().getUserDao();

		ArrayList<User> list = userDao.getByEmail(email);

		User validUser = list.get(0);

		if (validUser.getUserType().equals("A")) {
			return "admin/admin-home";
		}

		return "redirect:/courses/home?userId=" + validUser.getUserId();
	}

}
