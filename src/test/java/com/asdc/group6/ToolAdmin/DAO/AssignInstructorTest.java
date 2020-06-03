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
import com.asdc.group6.Models.User;
import com.asdc.group6.Utilities.ApplicationConstants;

@RunWith(MockitoJUnitRunner.class)
public class AssignInstructorTest {
	AssignInstructor assignInstructor = mock(AssignInstructorImpl.class);
	Course course;
	User user;
	ArrayList<User> userList = new ArrayList<>();

	public AssignInstructorTest() {
		user = new User();
		user.setUserId("111");
		user.setFirstName("James");
		user.setLastName("Smith");
		user.setEmail("james@dal.ca");
		userList.add(user);

		course = new Course();
		course.setCourseId("1");
		course.setCourseCode("6708");
		course.setCourseName("Adv. Web Development");
	}

	@Test
	public void testGetUserList() {
		when(assignInstructor.getUserList()).thenAnswer(new Answer<ArrayList<User>>() {
			@Override
			public ArrayList<User> answer(InvocationOnMock invocation) throws Throwable {
				return userList;
			}
		});
		assertEquals(assignInstructor.getUserList(), userList);
		verify(assignInstructor).getUserList();
	}

	@Test
	public void testAssignRoleToUser() {
		when(assignInstructor.assignRoleToUser(user, course.getCourseCode()))
				.thenReturn(ApplicationConstants.COURSE_ADDED);
		assertEquals(assignInstructor.assignRoleToUser(user, course.getCourseCode()),
				ApplicationConstants.COURSE_ADDED);
		verify(assignInstructor).assignRoleToUser(user, course.getCourseCode());
	}

	@Test
	public void testCheckIfCourseExistsForUser() {
		when(assignInstructor.checkIfCourseExistsForUser(user, course.getCourseCode())).thenReturn(true);
		assertEquals(assignInstructor.checkIfCourseExistsForUser(user, course.getCourseCode()), true);
		verify(assignInstructor).checkIfCourseExistsForUser(user, course.getCourseCode());
	}
}
