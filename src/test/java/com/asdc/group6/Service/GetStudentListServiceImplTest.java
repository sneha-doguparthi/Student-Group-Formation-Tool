package com.asdc.group6.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.asdc.group6.CourseAdmin.Service.GetStudentListServiceImpl;
import com.asdc.group6.Models.User;
import com.asdc.group6.Models.Student;

public class GetStudentListServiceImplTest {

	GetStudentListServiceImpl getStudentListServiceImplMock = mock(GetStudentListServiceImpl.class);
	
	@Test
	void testGetNewToCourseStudentList() {
		
		List<Student> studentList = new ArrayList<>();
		ArrayList<User> userList = new ArrayList<>();
		List<Student> result = new ArrayList<>();
		
		Student student = new Student();
		student.setbId("B00123456");
		student.setFirstName("Tony");
		student.setLastName("Stark");
		student.setEmail("ts@marveldal.ca");
		
		studentList.add(student);
		
		User user = new User();
		user.setUserId(5);
		user.setBannerId("B00123457");
		user.setFirstName("Captain");
		user.setLastName("America");
		user.setEmail("ca@marveldal.ca");
		user.setPassword("iamfrombrooklyn");
		user.setUserType("G");

		userList.add(user);
		
		result.add(student);
		
		when(getStudentListServiceImplMock.getNewToCourseStudentList(studentList, userList)).thenReturn(result);
		assertEquals(getStudentListServiceImplMock.getNewToCourseStudentList(studentList, userList), result, 
					"getNewToCourseStudentList Test Failed");
		verify(getStudentListServiceImplMock).getNewToCourseStudentList(studentList, userList);
	}


	@Test
	void testGetNewToPortalStudentList() {
		
		List<Student> studentList = new ArrayList<>();
		ArrayList<User> userList = new ArrayList<>();
		List<Student> result = new ArrayList<>();
		
		Student student = new Student();
		student.setbId("B00123456");
		student.setFirstName("Tony");
		student.setLastName("Stark");
		student.setEmail("ts@marveldal.ca");
		
		studentList.add(student);
		
		User user = new User();
		user.setUserId(5);
		user.setBannerId("B00123457");
		user.setFirstName("Captain");
		user.setLastName("America");
		user.setEmail("ca@marveldal.ca");
		user.setPassword("iamfrombrooklyn");
		user.setUserType("G");

		userList.add(user);
		
		result.add(student);
		
		
		when(getStudentListServiceImplMock.getNewToPortalStudentList(studentList, userList)).thenReturn(result);
		assertEquals(getStudentListServiceImplMock.getNewToPortalStudentList(studentList, userList), result, 
					"getNewToPortalStudentList Test Failed");
		verify(getStudentListServiceImplMock).getNewToPortalStudentList(studentList, userList);
	}

	
}
