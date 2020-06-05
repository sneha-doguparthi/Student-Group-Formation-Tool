package com.asdc.group6.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.asdc.group6.CourseAdmin.Service.SendInvitationEmailServiceImpl;
import com.asdc.group6.Models.Student;

public class SendInvitationEmailServiceImplTest {

	SendInvitationEmailServiceImpl sendInvitationEmailServiceImplMock = mock(SendInvitationEmailServiceImpl.class);
	
	@Test
	void sendUserInvitationEmail() {
		
		List<Student> studentList = new ArrayList<>();
		ArrayList<String> passwordList = new ArrayList<>();
		
		Student student = new Student();
		student.setbId("B00123456");
		student.setFirstName("Tony");
		student.setLastName("Stark");
		student.setEmail("ts@marveldal.ca");
		
		studentList.add(student);
		passwordList.add("thisisapassword");
		
		when(sendInvitationEmailServiceImplMock.sendUserInvitationEmail(studentList, passwordList)).thenReturn(true);
		assertTrue(sendInvitationEmailServiceImplMock.sendUserInvitationEmail(studentList, passwordList), 
					"getNewToCourseStudentList Test Failed");
		verify(sendInvitationEmailServiceImplMock).sendUserInvitationEmail(studentList, passwordList);
	}
	
	
	@Test
	void sendCourseInvitationEmail() {
		
		List<Student> studentList = new ArrayList<>();
		String courseCode = "CSCI5408";
		String courseName = "ASDC";
		
		Student student = new Student();
		student.setbId("B00123456");
		student.setFirstName("Tony");
		student.setLastName("Stark");
		student.setEmail("ts@marveldal.ca");
		
		studentList.add(student);
		
		when(sendInvitationEmailServiceImplMock.sendCourseInvitationEmail(studentList, courseCode, courseName)).thenReturn(true);
		assertTrue(sendInvitationEmailServiceImplMock.sendCourseInvitationEmail(studentList, courseCode, courseName), 
					"getNewToCourseStudentList Test Failed");
		verify(sendInvitationEmailServiceImplMock).sendCourseInvitationEmail(studentList, courseCode, courseName);
	}

	
}
