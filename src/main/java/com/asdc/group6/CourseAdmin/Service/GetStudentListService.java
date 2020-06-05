package com.asdc.group6.CourseAdmin.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.asdc.group6.Models.Student;
import com.asdc.group6.Models.User;

@Service
public interface GetStudentListService {

	public List<Student> getNewToPortalStudentList(List<Student> students, ArrayList<User> users);
	public List<Student> getNewToCourseStudentList(List<Student> students, ArrayList<User> users);
	
}
