package com.asdc.group6.ToolAdmin.Service;

import java.util.ArrayList;

import com.asdc.group6.ToolAdmin.DAO.DeleteCourse;
import com.asdc.group6.ToolAdmin.DAO.DeleteCourseImpl;

public class DeleteCourseServiceImpl implements DeleteCourseService {

	@Override
	public ArrayList<String> deleteCourse(ArrayList<String> courseToDelete) {
		DeleteCourse deleteCourse = new DeleteCourseImpl();
		ArrayList<String> courseList = deleteCourse.deleteCourse(courseToDelete);
		return courseList;
	}

}