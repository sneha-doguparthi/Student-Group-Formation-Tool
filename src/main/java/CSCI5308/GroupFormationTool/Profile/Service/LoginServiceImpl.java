package CSCI5308.GroupFormationTool.Profile.Service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import CSCI5308.GroupFormationTool.Model.User;
import CSCI5308.GroupFormationTool.Profile.DAO.IUserDao;
import CSCI5308.GroupFormationTool.Profile.DAO.ProfileDaoFactory;

public class LoginServiceImpl implements ILoginService {

	public String checkAccessService(String email, Model model) {

		IUserDao userDao = ProfileDaoFactory.instance().userDao();

		ArrayList<User> list = userDao.getByEmail(email);

		User validUser = list.get(0);

		if (validUser.getUserType().equals("A")) {
			return "admin/admin-home";
		}

		return "redirect:/courses/home?userId=" + validUser.getUserId();
	}

}
