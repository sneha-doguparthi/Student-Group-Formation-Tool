package com.asdc.group6.CourseAdmin.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.asdc.group6.Models.Student;
import com.asdc.group6.Models.User;

@Service
public interface UserDao {

	ArrayList<User> getByEmail(String email);

	Boolean update(User user);

	public ArrayList<User> getUserByUserID(ArrayList<Integer> userIds);

	public ArrayList<User> getAll();

	public ArrayList<Integer> getUserID(List<Student> students);

	public boolean addUser(List<Student> newToPortalList);

	public ArrayList<String> getPassword(List<Student> students);
}
