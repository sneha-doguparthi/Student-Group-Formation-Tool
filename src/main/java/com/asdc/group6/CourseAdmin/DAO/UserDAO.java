package com.asdc.group6.CourseAdmin.DAO;

import java.util.ArrayList;
import java.util.List;

import com.asdc.group6.Models.User;
import com.asdc.group6.Models.Student;

public interface UserDAO {

	public ArrayList<User> getUserByUserID(ArrayList<Integer> userIds);
	public ArrayList<User> getAll();
	public ArrayList<Integer> getUserID(List<Student> students);
	public boolean addUser(List<Student> newToPortalList);
	public ArrayList<String> getPassword(List<Student> students);
	
}
