package com.asdc.group6.ToolAdmin.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import org.mockito.stubbing.Answer;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;

import com.asdc.group6.Models.Course;

public class ViewCoursesServiceTest {
	ViewCoursesService viewCoursesService = mock(ViewCoursesServiceImpl.class);
	Course course;
	ArrayList<Course> courseList = new ArrayList<>();

	public ViewCoursesServiceTest() {
		course = new Course();
		course.setCourseId("1");
		course.setCourseCode("6708");
		course.setCourseName("Adv. Web Development");
		courseList.add(course);
	}

	@Test
	public void getCourseList() {
		when(viewCoursesService.getCourseList()).thenAnswer(new Answer<ArrayList<Course>>() {

			@Override
			public ArrayList<Course> answer(InvocationOnMock invocation) throws Throwable {
				return courseList;
			}

		});
		assertEquals(viewCoursesService.getCourseList(), courseList);
		verify(viewCoursesService).getCourseList();
	}
}
