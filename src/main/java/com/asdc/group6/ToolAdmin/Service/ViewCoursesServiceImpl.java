package com.asdc.group6.ToolAdmin.Service;

import java.util.ArrayList;

import com.asdc.group6.Models.Course;
import com.asdc.group6.ToolAdmin.DAO.ViewCourses;
import com.asdc.group6.ToolAdmin.DAO.ViewCoursesImpl;

public class ViewCoursesServiceImpl implements ViewCoursesService {
	@Override
	public ArrayList<Course> getCourseList() {
		ViewCourses viewCourses = new ViewCoursesImpl();
		ArrayList<Course> courseList = viewCourses.getCourseList();
		return courseList;
	}
}