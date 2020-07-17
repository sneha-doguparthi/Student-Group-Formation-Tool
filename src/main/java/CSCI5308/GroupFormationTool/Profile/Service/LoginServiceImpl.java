package CSCI5308.GroupFormationTool.Profile.Service;

import java.util.ArrayList;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;

import CSCI5308.GroupFormationTool.Profile.IUser;
import CSCI5308.GroupFormationTool.Profile.DAO.IUserDao;
import CSCI5308.GroupFormationTool.Profile.DAO.ProfileDaoFactory;

public class LoginServiceImpl implements ILoginService {

	public String checkAccessService(String email, Model model) {
		IUserDao userDao = ProfileDaoFactory.instance().userDao();
		ArrayList<IUser> list = userDao.getByEmail(email);
		IUser validUser = list.get(0);
		if (validUser.getUserType().equals("A")) {
			return "admin/admin-home";
		}
		return "redirect:/courses/home?userId=" + validUser.getUserId();
	}

	@Override
	public int getUserId() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		IUserDao userDao = ProfileDaoFactory.instance().userDao();
		ArrayList<IUser> list = userDao.getByEmail(authentication.getName());
		return list.get(0).getUserId();
	}

}
