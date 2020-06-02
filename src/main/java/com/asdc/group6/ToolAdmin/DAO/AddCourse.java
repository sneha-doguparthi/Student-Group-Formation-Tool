package com.asdc.group6.ToolAdmin.DAO;

import com.asdc.group6.Models.Course;

public interface AddCourse {
	public String addNewCourse(Course course);
	public boolean checkIfCourseExists(Course course);
}