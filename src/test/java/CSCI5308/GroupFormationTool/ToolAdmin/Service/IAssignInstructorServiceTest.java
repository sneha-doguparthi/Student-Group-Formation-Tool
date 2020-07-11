package CSCI5308.GroupFormationTool.ToolAdmin.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import CSCI5308.GroupFormationTool.Course.Course;
import CSCI5308.GroupFormationTool.Model.User;
import CSCI5308.GroupFormationTool.Utilities.ApplicationConstants;

public class IAssignInstructorServiceTest {
	IAssignInstructorService assignInstructorService = mock(AssignInstructorServiceImpl.class);
	Course course;
	User user;
	ArrayList<User> userList = new ArrayList<>();

	public IAssignInstructorServiceTest() {
		user = new User();
		user.setFirstName("James");
		user.setLastName("Smith");
		user.setEmail("james@dal.ca");
		userList.add(user);

		course = new Course();
		course.setCourseId(1);
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
