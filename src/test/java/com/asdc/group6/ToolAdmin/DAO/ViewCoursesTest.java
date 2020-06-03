package com.asdc.group6.ToolAdmin.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import org.mockito.stubbing.Answer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;

import com.asdc.group6.Models.Course;

@RunWith(MockitoJUnitRunner.class)
public class ViewCoursesTest {
	ViewCourses viewCourses = mock(ViewCoursesImpl.class);
	Course course;
	ArrayList<Course> courseList = new ArrayList<>();

	public ViewCoursesTest() {
		course = new Course();
		course.setCourseId("1");
		course.setCourseCode("6708");
		course.setCourseName("Adv. Web Development");
		courseList.add(course);
	}

	@Test
	public void getCourseList() {
		when(viewCourses.getCourseList()).thenAnswer(new Answer<ArrayList<Course>>() {

			@Override
			public ArrayList<Course> answer(InvocationOnMock invocation) throws Throwable {
				return courseList;
			}

		});
		assertEquals(viewCourses.getCourseList(), courseList);
		verify(viewCourses).getCourseList();
	}
}
