package com.asdc.group6.Profile.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import com.asdc.group6.Models.Course;
import com.asdc.group6.Profile.Login.DAO.CourseDaoImpl;

public class CourseDaoImplTest {

	CourseDaoImpl courseDaoImplMock = mock(CourseDaoImpl.class);
	
	@Test
	void testGetAll() {
		
		ArrayList<Course> list = new ArrayList<>();
		
		Course courses = new Course();
		
		courses.setCourseId("1");
		courses.setCourseCode("CSCI5100");
		courses.setCourseName("Communication Skills");
		
		list.add(courses);
		
		when(courseDaoImplMock.getAll()).thenReturn(list);
		assertEquals(courseDaoImplMock.getAll(), list, "Error getting course data");
		verify(courseDaoImplMock).getAll();
	}
	
	@Test
	void testGetById() {
		
		Course course = new Course();
		course.setCourseId("1");
		course.setCourseCode("CSCI5100");
		course.setCourseName("Communication Skills");
		
		when(courseDaoImplMock.getById(1)).thenReturn(course);
		assertEquals(courseDaoImplMock.getById(1), course, "Objects does not match");
		verify(courseDaoImplMock).getById(1);
	}
}
