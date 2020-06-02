package com.asdc.group6.ToolAdmin.DAO;

import java.util.ArrayList;

import com.asdc.group6.Models.User;

public interface AssignInstructor {
	public ArrayList<User> getUserList();

	public String assignRoleToUser(User user, String courseCode);
}