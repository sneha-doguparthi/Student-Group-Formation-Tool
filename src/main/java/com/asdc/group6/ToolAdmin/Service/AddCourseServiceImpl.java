package com.asdc.group6.ToolAdmin.Service;

import com.asdc.group6.Models.Course;
import com.asdc.group6.ToolAdmin.DAO.AddCourseImpl;

public class AddCourseServiceImpl implements AddCourseService {

	@Override
	public String addNewCourse(Course course) {
		AddCourseImpl addCourse = new AddCourseImpl();
		return addCourse.addNewCourse(course);
	}

}