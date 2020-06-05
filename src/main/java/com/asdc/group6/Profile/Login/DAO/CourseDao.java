package com.asdc.group6.Profile.Login.DAO;

import java.util.ArrayList;
import com.asdc.group6.Models.Course;

public interface CourseDao {

	ArrayList<Course> getAll();
	
	Course getById(Integer id);
}
