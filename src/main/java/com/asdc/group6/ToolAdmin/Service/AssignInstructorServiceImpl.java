package com.asdc.group6.ToolAdmin.Service;

import java.util.ArrayList;

import com.asdc.group6.Models.User;
import com.asdc.group6.ToolAdmin.DAO.AssignInstructorImpl;

public class AssignInstructorServiceImpl implements AssignInstructorService {

	@Override
	public ArrayList<User> getUserList() {
		AssignInstructorImpl assignInstructorImpl = new AssignInstructorImpl();
		return assignInstructorImpl.getUserList();
	}

	@Override
	public String assignRoleToUser(User user, String courseCode) {
		if (null != getCourseCodeFromString(courseCode)) {
			AssignInstructorImpl assignInstructorImpl = new AssignInstructorImpl();
			return assignInstructorImpl.assignRoleToUser(user, courseCode);
		}
		return null;
	}

	@Override
	public String getCourseCodeFromString(String courseCode) {
		if (null != courseCode) {
			return courseCode.split(" - ")[0];
		}
		return null;
	}

}