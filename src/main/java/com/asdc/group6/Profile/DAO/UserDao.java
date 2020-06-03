package com.asdc.group6.Profile.DAO;

import java.util.ArrayList;

import com.asdc.group6.Models.User;

public interface UserDao {

	ArrayList<User> getAll();
	
	ArrayList<User> getByEmail(String email);
	
	Boolean update(User user);
}
