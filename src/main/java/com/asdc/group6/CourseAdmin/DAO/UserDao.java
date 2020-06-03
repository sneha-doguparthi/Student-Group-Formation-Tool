package com.asdc.group6.CourseAdmin.DAO;

import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.asdc.group6.Models.User;

@Service
public interface UserDao {
	
	ArrayList<User> getAll();
	
	ArrayList<User> getByEmail(String email);
	
	Boolean update(User user);
}
