package com.asdc.group6.ToolAdmin.Service;

import java.util.ArrayList;

import com.asdc.group6.Models.User;

public interface AssignInstructorService {
	public ArrayList<User> getUserList();

	public String assignRoleToUser(User user, String courseCode);

	public String getCourseCodeFromString(String courseCode);
}