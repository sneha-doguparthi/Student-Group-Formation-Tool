package com.asdc.group6.ToolAdmin.Service;

import java.util.ArrayList;

import com.asdc.group6.ToolAdmin.DAO.DeleteCourseImpl;

public class DeleteCourseServiceImpl implements DeleteCourseService {

	@Override
	public ArrayList<String> deleteCourse(ArrayList<String> courseToDelete) {
		DeleteCourseImpl deleteCourseImpl = new DeleteCourseImpl();
		ArrayList<String> courseList = deleteCourseImpl.deleteCourse(courseToDelete);
		return courseList;
	}

}