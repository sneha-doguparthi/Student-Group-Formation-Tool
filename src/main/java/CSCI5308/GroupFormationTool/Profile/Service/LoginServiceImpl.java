package CSCI5308.GroupFormationTool.Profile.Service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import CSCI5308.GroupFormationTool.CourseAdmin.DAO.CourseAssociationDAO;
import CSCI5308.GroupFormationTool.CourseAdmin.DAO.CourseAssociationDAOImpl;
import CSCI5308.GroupFormationTool.CourseAdmin.DAO.CourseDao;
import CSCI5308.GroupFormationTool.CourseAdmin.DAO.CourseDaoImpl;
import CSCI5308.GroupFormationTool.Model.Course;
import CSCI5308.GroupFormationTool.Model.CourseAssociation;
import CSCI5308.GroupFormationTool.Model.User;
import CSCI5308.GroupFormationTool.Profile.DAO.UserDao;
import CSCI5308.GroupFormationTool.Profile.DAO.UserDaoImpl;
import CSCI5308.GroupFormationTool.Utilities.ApplicationConstants;

public class LoginServiceImpl implements LoginService {

	public String checkAccessService(User user, Model model) {

		CourseAssociationDAO courseAssociationDao = new CourseAssociationDAOImpl();
		UserDao userDao = new UserDaoImpl();
		CourseDao courseDao = new CourseDaoImpl();

		ArrayList<User> list = userDao.getByEmail(user.getEmail());

		// No user found with provided email;
		if (list.size() == 0)
			return "profile/login";

		// Incorrect Password
		if (!list.get(0).getPassword().equals(user.getPassword()))
			return "profile/login";

		// Getting the data of valid user from database
		User validUser = list.get(0);

		// If user type is admin then redirect to admin page
		if (validUser.getUserType().equals("A")) {
			return "admin/admin-home";
		}

		// check inside association table for logged in user
		ArrayList<CourseAssociation> associationList = courseAssociationDao.getByUserId(validUser.getUserId());

		// if user is not enrolled in any courses then list all courses
		// this would be the guest user case
		if (associationList.size() == 0) {
			ArrayList<Course> courses = courseDao.getAll();
			model.addAttribute("courses", courses);

			return "course/all-courses";
		}

		// if user is student and also a TA then differentiate both entries
		ArrayList<Course> studentCourse = new ArrayList<Course>();
		ArrayList<Course> instructorAndTaCourse = new ArrayList<Course>();

		for (CourseAssociation a : associationList) {

			if (a.getRoleId() == (ApplicationConstants.STUDENT_ROLE_ID)) {
				studentCourse.add(courseDao.getById(a.getCourseId()));
			} else if (a.getRoleId() == (ApplicationConstants.TA_ROLE_ID)
					|| a.getRoleId() == (ApplicationConstants.INSTRUCTOR_ROLE_ID)) {
				instructorAndTaCourse.add(courseDao.getById(a.getCourseId()));
			}
		}

		model.addAttribute("studentCourse", studentCourse);
		model.addAttribute("instructorAndTaCourse", instructorAndTaCourse);

		return "course/course-list";
	}
}
