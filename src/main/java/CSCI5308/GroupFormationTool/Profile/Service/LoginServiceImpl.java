package CSCI5308.GroupFormationTool.Profile.Service;

import java.util.ArrayList;

import CSCI5308.GroupFormationTool.Course.DAO.CourseAssociationDAO;
import CSCI5308.GroupFormationTool.Course.DAO.CourseAssociationDAOImpl;
import CSCI5308.GroupFormationTool.Course.DAO.CourseDao;
import CSCI5308.GroupFormationTool.Course.DAO.CourseDaoImpl;
import CSCI5308.GroupFormationTool.Model.Course;
import CSCI5308.GroupFormationTool.Model.CourseAssociation;
import CSCI5308.GroupFormationTool.Utilities.ApplicationConstants;
import org.springframework.ui.Model;

import CSCI5308.GroupFormationTool.Model.User;
import CSCI5308.GroupFormationTool.Profile.DAO.UserDao;
import CSCI5308.GroupFormationTool.Profile.DAO.UserDaoImpl;

public class LoginServiceImpl implements LoginService {

	public String checkAccessService(String email, Model model) {

		UserDao userDao = new UserDaoImpl();

		ArrayList<User> list = userDao.getByEmail(email);

		// Getting the data of valid user from database
		User validUser = list.get(0);

		// If user type is admin then redirect to admin page
		if (validUser.getUserType().equals("A")) {
			return "admin/admin-home";
		}

		return "redirect:/courses/home?userId=" + validUser.getUserId();
	}
}
