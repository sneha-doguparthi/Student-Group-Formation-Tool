package com.asdc.group6.Profile.Login.Service;

import java.util.ArrayList;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import com.asdc.group6.Models.Association;
import com.asdc.group6.Models.Course;
import com.asdc.group6.Models.User;
import com.asdc.group6.Profile.Login.DAO.AssociationDao;
import com.asdc.group6.Profile.Login.DAO.CourseDao;
import com.asdc.group6.Profile.Login.DAO.UserDao;
import com.asdc.group6.Utilities.ApplicationConstants;

@Component
public class LoginServiceImpl implements LoginService {
	private AssociationDao associationDao;
	private UserDao userDao;
	private CourseDao courseDao;

	public LoginServiceImpl(AssociationDao associationDao, UserDao userDao, CourseDao courseDao) {
		this.associationDao = associationDao;
		this.userDao = userDao;
		this.courseDao = courseDao;
	}

	public String checkAccessService(User user, Model model) {

		ArrayList<User> list = userDao.getByEmail(user.getEmail());

		// No user found with provided email;
		if (list.size() == 0)
			return "login";

		// Incorrect Password
		if (!list.get(0).getPassword().equals(user.getPassword()))
			return "login";

		// Getting the data of valid user from database
		User validUser = list.get(0);

		// If user type is admin then redirect to admin page
		if (validUser.getUserType().equals("A")) {
			return "admin-home";
		}

		// check inside association table for logged in user
		ArrayList<Association> associationList = associationDao.getByUserId(validUser.getUserId());

		// if user is not enrolled in any courses then list all courses
		// this would be the guest user case
		if (associationList.size() == 0) {
			ArrayList<Course> courses = courseDao.getAll();
			model.addAttribute("courses", courses);

			return "all-courses";
		}

		// if user is student and also a TA then differentiate both entries
		ArrayList<Course> studentCourse = new ArrayList<Course>();
		ArrayList<Course> instructorAndTaCourse = new ArrayList<Course>();

		for (Association a : associationList) {

			if (Integer.parseInt(a.getRoleId()) == (ApplicationConstants.STUDENT_ROLE_ID)) {
				studentCourse.add(courseDao.getById(a.getCourseId()));
			} else if (Integer.parseInt(a.getRoleId()) == (ApplicationConstants.TA_ROLE_ID)
					|| Integer.parseInt(a.getRoleId()) == (ApplicationConstants.INSTRUCTOR_ROLE_ID)) {
				instructorAndTaCourse.add(courseDao.getById(a.getCourseId()));
			}
		}

		model.addAttribute("studentCourse", studentCourse);
		model.addAttribute("instructorAndTaCourse", instructorAndTaCourse);

		return "course-list";
	}
}
