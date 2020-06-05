package com.asdc.group6.CourseAdmin.Service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.asdc.group6.Models.Student;
import com.asdc.group6.Models.User;

@Service
public interface SendInvitationEmailService {

	public boolean sendCourseInvitationEmail(List<Student> newToCourseList, String courseCode, String courseName);
	public boolean sendUserInvitationEmail(List<Student> newToPortalList, ArrayList<String> passwords);
	
}
