package com.asdc.group6.ToolAdmin.Service;

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
public class AssignInstructorServiceTest {
	AssignInstructorService assignInstructorService = mock(AssignInstructorServiceImpl.class);
	Course course;
	User user;
	ArrayList<User> userList = new ArrayList<>();

	public AssignInstructorServiceTest() {
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
		when(assignInstructorService.getUserList()).thenAnswer(new Answer<ArrayList<User>>() {
			@Override
			public ArrayList<User> answer(InvocationOnMock invocation) throws Throwable {
				return userList;
			}
		});
		assertEquals(assignInstructorService.getUserList(), userList);
		verify(assignInstructorService).getUserList();
	}

	@Test
	public void testAssignRoleToUser() {
		when(assignInstructorService.assignRoleToUser(user, course.getCourseCode()))
				.thenReturn(ApplicationConstants.COURSE_ADDED);
		assertEquals(assignInstructorService.assignRoleToUser(user, course.getCourseCode()),
				ApplicationConstants.COURSE_ADDED);
		verify(assignInstructorService).assignRoleToUser(user, course.getCourseCode());
	}
}
