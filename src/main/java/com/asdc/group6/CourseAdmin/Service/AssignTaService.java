package com.asdc.group6.CourseAdmin.Service;

import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.asdc.group6.Models.User;

@Service
public interface AssignTaService {
	
	ArrayList<User> getAllUsers();
	
	Boolean assignTa(String userId, Integer courseId);
}
