package com.asdc.group6.Profile.Login.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.asdc.group6.Models.Course;
import com.asdc.group6.Models.User;
import com.asdc.group6.Profile.UserCourses;
import com.asdc.group6.Profile.Login.DAO.UserLoginDao;
import com.asdc.group6.Profile.Login.DAO.UserLoginDaoImpl;

public class LoginServiceImpl implements LoginService {

	@Autowired
	UserCourses usercourses;

	public String checkAccessService(User user) {
		
		UserLoginDao userLoginDao = new UserLoginDaoImpl();
		// String initialPage;
		if (userLoginDao.checkAccess(user)) {
			switch (user.getUserType()) {
			case "A":
				return "AdminHome";
			case "S":
				Course c = new Course();
				if (usercourses.fetchCourses(user, c))
					c.getCourseList();
				System.out.println(c.getCourseList());
				return "registered_courses";
			}
			return "all_courses";
		} else {
			return "login";
		}
	}

}
